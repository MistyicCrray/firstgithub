package com.springboot.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.User;
import com.springboot.service.OrderService;
import com.springboot.service.ProductService;
import com.springboot.service.ShoppingCartService;
import com.springboot.service.UserService;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.MD5;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.ServiceException;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	// 读取配置文件中的参数
	@Value("${spring.mail.username}")
	private String form;

	@Value("${local_url}")
	private String domain;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	/**
	 * 用户注册
	 * 
	 * @Title: insertUser
	 * @Description: TODO
	 * @param user
	 * @param file
	 * @return Result
	 * @throws MessagingException
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result insertUser(@RequestBody User user, @RequestParam(required = false) MultipartFile file)
			throws MessagingException {
		MimeMessage meMimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(meMimeMessage, true, "UTF-8");
		// 生成六位数字验证码
		String activeCode = "";
		activeCode += (int) (Math.random() * 9 + 1);
		for (int i = 0; i < 5; i++) {
			activeCode += (int) (Math.random() * 10);
		}
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 2); // 存入过期时间
		if (!user.getLoginname().matches("^\\w+@(\\w+\\.)+\\w+$")) {
			throw new ServiceException("邮箱不合法");
		}
		// 检测用户登录账号是否存在
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginname", user.getLoginname());
		List<User> list = userService.findList(map);
		if (list.size() != 0) {
			if (list.get(0).getState().equals("0")) {
				throw new ServiceException("邮箱已被注册");
			}
			// 如账号存在并且没激活则重新发送邮件，并且更新该用户数据
			if (list.get(0).getState().equals("4")) {
				Map<String, Object> userMap = new HashMap<String, Object>();
				userMap.put("activeCode", activeCode);
				userMap.put("activeDate", now.getTime());
				userMap.put("id", list.get(0).getId());
				userMap.put("password", MD5.md5(user.getPassword()));
				// 发送者
				messageHelper.setFrom(form);
				// 接收者
				messageHelper.setTo(user.getLoginname());
				// 邮件主题
				meMimeMessage.setSubject("激活邮箱");
				// 邮件内容
				meMimeMessage.setContent("点击激活邮箱：<a href='" + domain + "?id=" + list.get(0).getId() + "&activeCode="
						+ activeCode + "'>" + domain + "?id=" + list.get(0).getId() + "&activeCode=" + activeCode
						+ "</a>该链接48小时内有效", "text/html;charset=UTF-8");
				javaMailSender.send(meMimeMessage);
				userService.update(userMap, file);
				return ResultGenerator.genSuccessResult("success");
			}
		}
		user.setId(com.springboot.tools.UUIDUtils.get16UUID());
		user.setActivecode(activeCode);
		user.setActivedate(now.getTime()); // 存入过期时间,两天后过期
		user.setState("4"); // 未激活状态
		// 发送者
		messageHelper.setFrom(form);
		// 接收者
		messageHelper.setTo(user.getLoginname());
		// 邮件主题
		meMimeMessage.setSubject("激活邮箱");
		// 邮件内容
		meMimeMessage.setContent(
				"点击激活邮箱：<a href='" + domain + "?id=" + user.getId() + "&activeCode=" + activeCode + "'>" + domain
						+ "?id=" + user.getId() + "&activeCode=" + activeCode + "</a>该链接48小时内有效",
				"text/html;charset=UTF-8");
		javaMailSender.send(meMimeMessage);
		return ResultGenerator.genSuccessResult(userService.add(user));

	}

	/**
	 * 
	 * @param id
	 * @param activeCode
	 * @return
	 */
	@RequestMapping(value = "/active", method = RequestMethod.GET)
	public Result activeEmail(@RequestParam String id, @RequestParam String activeCode) {
		User user = userService.findById(id);
		if (user == null) {
			throw new ServiceException("用户还未注册，请前往注册页面");
		}
		if (!activeCode.equals(user.getActivecode())) {
			throw new ServiceException("激活码错误");
		}
		if (new Date().getTime() >= user.getActivedate().getTime()) {
			userService.delete(id);
			throw new ServiceException("该链接已经过期,请重新注册");
		}
		// 激活成功时清空这两个字段,防止重复激活
		user.setActivecode(null);
		user.setActivedate(null);
		user.setState("0"); // 设置为正常可用状态
		userService.updateByUser(user);
		return ResultGenerator.genSuccessResult("success");
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result getUsers(Integer pageNum, Integer size, @ModelAttribute User user,
			@RequestParam(required = false) Map<String, Object> map) {
		Page<User> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		return ResultGenerator.genSuccessResult(new TableData<User>(page.getTotal(), userService.findList(map)));
	}

	/**
	 * 修改密码
	 * 
	 * @Title: updatePwd
	 * @Description: TODO
	 * @param id
	 * @param map
	 * @return Result
	 */
	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result updatePwd(@PathVariable String id, @RequestParam(required = false) Map<String, Object> map) {
		map.put("id", id);
		String oldPassword = (String) map.get("oldPassword");
		String newPassword = (String) map.get("newPassword");
		String confirmPassword = (String) map.get("confirmPassword");
		if (!newPassword.equals(confirmPassword)) {
			return ResultGenerator.genSuccessResult("两次输入密码不一致");
		}
		if (newPassword.equals(oldPassword)) {
			return ResultGenerator.genSuccessResult("新密码和旧密码不能相同");
		}
		map.put("password", MD5.md5(newPassword));
		userService.updatePassword(map);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	/**
	 * 获取个人信息
	 * 
	 * @Title: getById
	 * @Description: TODO
	 * @param id
	 * @return Result
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result getById(@PathVariable String id) {
		User user = userService.findById(id);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", user.getId());
		map.put("shoppingCart", shoppingCartService.findList(paramMap)); // 购物车
		map.put("order", orderService.findList(paramMap)); // 订单
		map.put("product", productService.findList(paramMap)); // 上架的商品
		return ResultGenerator.genSuccessResult(JSONObject.toJSON(map));
	}

	/**
	 * 登录
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public Result Login(@RequestBody(required = false) Map<String, Object> map,
			@RequestParam(required = false) MultipartFile file) {
		map.put("password", MD5.md5((String) map.get("password")));
		if (userService.login(map) == null) {
			throw new ServiceException("用户名或密码错误");
		}
		List<User> users = userService.findList(map);
		if (users.size() != 0) {
			if (users.get(0).getState().equals("2"))
				throw new ServiceException("用户未激活");
		}
		Map<String, Object> userMap = new HashMap<>();
		userMap.put("id", users.get(0).getId());
		userMap.put("lastLoginTime", new Date());
		userService.update(userMap, file);
		return ResultGenerator.genSuccessResult(userService.login(map));
	}

	@LoginRequired
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable String id, @RequestParam(required = false) MultipartFile file) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		return ResultGenerator.genSuccessResult(userService.update(map, file));
	}
}