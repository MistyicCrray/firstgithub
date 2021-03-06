package com.springboot.controller;

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
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.MD5;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.SendEmailUtil;
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
	public Result insertUser(@RequestBody User user) throws MessagingException {
		User add = userService.add(user);
		return ResultGenerator.genSuccessResult(add);
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
			return ResultGenerator.genFailResult("用户还未注册，请前往注册页面");
		}
		if (user.getState().equals("0") && StringUtil.isEmpty(user.getActivecode())) {
			return ResultGenerator.genFailResult("该邮箱已激活");
		}
		if (!activeCode.equals(user.getActivecode())) {
			return ResultGenerator.genFailResult("激活码错误");
		}
		// 链接过期则删除用户信息
		if (new Date().getTime() >= user.getActivedate().getTime()) {
			userService.delete(id);
			return ResultGenerator.genFailResult("该链接已经过期,请重新注册");
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
	@LoginRequired
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
		map.put("password", MD5.md5(map.get("password").toString()));
		List<User> users = userService.findList(map);
		if (users.size() == 0) {
			return ResultGenerator.genFailResult("用户名或密码错误");
		}
		if (users.size() != 0) {
			if (users.get(0).getState().equals("2")) {
				return ResultGenerator.genFailResult("用户未激活");
			}
			if (users.get(0).getState().equals("1")) {
				return ResultGenerator.genFailResult("用户已被冻结");
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
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Result update(@CurrentUser User user, @RequestParam(required = false) Map<String, Object> map,
			@RequestParam(required = false) MultipartFile img) {
		map.put("id", user.getId());
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
	 * 重置密码
	 * 
	 * @param id
	 * @return
	 */
	@LoginRequired
	@RequestMapping(value = "/reset/{id}", method = RequestMethod.PUT)
	public Result resetPwd(@PathVariable String id, @CurrentUser User currentUser) {
		if (!currentUser.getUsertype().equals("1")) {
			return ResultGenerator.genFailResult("您无权访问");
		}
		User user = userService.findById(id);
		user.setPassword(MD5.md5("123456"));
		return ResultGenerator.genSuccessResult(userService.updateByUser(user));
	}

	/**
	 * 用户修改密码
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/forgot_password", method = RequestMethod.PUT)
	public Result forgot(@RequestBody Map<String, Object> map) {
		User user = userService.findByLoginName(map.get("loginname").toString());
		if (!user.getActivecode().equals(map.get("activeCode").toString())) {
			return ResultGenerator.genFailResult("动态验证码不正确");
		}
		if (StringUtil.isNotEmpty(map.get("password").toString())) {
			user.setPassword(MD5.md5(map.get("password").toString()));
			// 修改成功时清空字段
			user.setActivecode("");
			userService.updateByUser(user);
		}
		return ResultGenerator.genSuccessResult("修改成功");
	}

	/**
	 * 修改密码时发送邮件
	 * 
	 * @param from
	 * @return
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/send_email/{sendTo}", method = RequestMethod.POST)
	public Result sendEmail(@PathVariable(value = "sendTo") String sendTo) throws MessagingException {
		Map<String, Object> map = new HashMap<>();
		map.put("loginname", sendTo);
		List<User> users = userService.findList(map);
		if (users.size() == 0) {
			return ResultGenerator.genFailResult("该邮箱尚未注册");
		} else {
			User user = users.get(0);
			if (user.getState().equals("2")) {
				return ResultGenerator.genFailResult("该邮箱尚未激活，请前往邮箱激活");
			}
			String activeCode = UUIDUtils.getActiveCode();
			// 发送邮件
			SendEmailUtil.send(activeCode, user.getLoginname(), "修改密码动态码", javaMailSender, form);
			// 添加动态码
			user.setActivecode(activeCode);
			userService.updateByUser(user);
		}
		return ResultGenerator.genSuccessResult("邮件发送成功");
	}

	/**
	 * 管理员修改用户信息
	 * 
	 * @param id
	 * @param file
	 * @return
	 */
	@LoginRequired
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Result adminUpdate(@CurrentUser User user, @PathVariable String id, @RequestBody Map<String, Object> map,
			@RequestParam(required = false) MultipartFile img) {
		map.remove("password");
		map.put("id", id);
		return ResultGenerator.genSuccessResult(userService.update(map, img));
	}

	/**
	 * 管理员添加用户信息
	 * 
	 * @param id
	 * @param file
	 * @return
	 */
	@LoginRequired
	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public Result adminAdd(@CurrentUser User currentUser, @RequestBody User user) {
		if (!currentUser.getUsertype().equals("1")) {
			return ResultGenerator.genFailResult("您没有权限访问");
		}
		return ResultGenerator.genSuccessResult(userService.addAdmin(user));
	}

}