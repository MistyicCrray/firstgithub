package com.springboot.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.springboot.entity.User;
import com.springboot.service.UserService;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.MD5;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.SendEmailUtil;
import com.springboot.tools.ServiceException;
import com.springboot.tools.TableData;
import com.springboot.tools.UUIDUtils;

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
		String activeCode = UUIDUtils.getActiveCode();
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
				// 发送邮件
				SendEmailUtil.send("点击激活邮箱：<a href='" + domain + "?id=" + list.get(0).getId() + "&activeCode="
						+ activeCode + "'>" + domain + "?id=" + list.get(0).getId() + "&activeCode=" + activeCode
						+ "</a>该链接48小时内有效", user.getLoginname(), "激活邮箱", javaMailSender, form);

				userService.update(userMap, file);
				return ResultGenerator.genSuccessResult("success");
			}
		}
		user.setId(UUIDUtils.get16UUID());
		user.setActivecode(activeCode);
		user.setActivedate(now.getTime()); // 存入过期时间,两天后过期
		user.setState("4"); // 未激活状态
		// 发送邮件
		SendEmailUtil.send(
				"点击激活邮箱：<a href='" + domain + "?id=" + user.getId() + "&activeCode=" + activeCode + "'>" + domain
						+ "?id=" + user.getId() + "&activeCode=" + activeCode + "</a>该链接48小时内有效",
				user.getLoginname(), "激活邮箱", javaMailSender, form);
		return ResultGenerator.genSuccessResult(userService.add(user));

	}

	/**
	 * 邮箱激活
	 * 
	 * @param id
	 * @param activeCode
	 * @return
	 */
	@RequestMapping(value = "/active/{id}/{activeCode}", method = RequestMethod.GET)
	public Result activeEmail(@PathVariable String id, @PathVariable String activeCode) {
		User user = userService.findById(id);
		if (user == null) {
			throw new ServiceException("用户还未注册，请前往注册页面");
		}
		if (user.getState().equals("0") && StringUtil.isEmpty(user.getActivecode())) {
			throw new ServiceException("该邮箱已激活");
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
		List<User> findList = userService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<User>(page.getTotal(), findList));
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
		User user = userService.findById(id);
		String oldPassword = (String) map.get("oldPassword");
		String newPassword = (String) map.get("newPassword");
		String confirmPassword = (String) map.get("confirmPassword");
		if (!MD5.md5(oldPassword).equals(user.getPassword())) {
			return ResultGenerator.genFailResult("输入的密码不正确");
		}
		if (!newPassword.equals(confirmPassword)) {
			return ResultGenerator.genFailResult("两次输入密码不一致");
		}
		if (newPassword.equals(oldPassword)) {
			return ResultGenerator.genFailResult("新密码和旧密码不能相同");
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
		return ResultGenerator.genSuccessResult(user);
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
			if (users.get(0).getState().equals("2")) {
				throw new ServiceException("用户未激活");
			}
			if (users.get(0).getState().equals("1")) {
				throw new ServiceException("用户已被冻结");
			}
		}

		Map<String, Object> userMap = new HashMap<>();
		userMap.put("id", users.get(0).getId());
		userMap.put("lastLoginTime", new Date());
		userService.update(userMap, file);
		return ResultGenerator.genSuccessResult(userService.login(map));
	}

	/**
	 * 修改用户信息
	 * 
	 * @param id
	 * @param file
	 * @return
	 */
	@LoginRequired
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Result update(@PathVariable String id, @RequestParam(required = false) Map<String, Object> map,
			@RequestParam(required = false) MultipartFile img) {
		map.put("id", id);
		map.remove("password");
		return ResultGenerator.genSuccessResult(userService.update(map, img));
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(userService.delete(id));
	}

	/**
	 * 添加管理用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result addAdmin(@RequestBody User user) {
		user.setUsertype("admin");
		return ResultGenerator.genSuccessResult(userService.add(user));
	}

	/**
	 * 重置密码
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/reset/{id}", method = RequestMethod.POST)
	public Result resetPwd(@PathVariable String id) {
		User user = userService.findById(id);
		user.setPassword(MD5.md5("123456"));
		return ResultGenerator.genSuccessResult(userService.updateByUser(user));
	}

}