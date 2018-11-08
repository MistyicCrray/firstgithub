package com.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.User;
import com.springboot.service.UserService;
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

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result insertUser(@ModelAttribute User user, @RequestParam(required = false) MultipartFile file) {
		return ResultGenerator.genSuccessResult(userService.addUser(user, file));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result getUsers(Integer pageNum, Integer size, @ModelAttribute User user, @RequestParam(required = false) Map<String, Object> map) {
		Page<User> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		return ResultGenerator.genSuccessResult(new TableData<User>(page.getTotal(), userService.getUsers(map)));
	}

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

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Result getById(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(userService.getById(id));
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public Result Login(@RequestParam(required = false) Map<String, Object> map) {
		map.put("password", MD5.md5((String) map.get("password")));
		if (userService.login(map) == null) {
			throw new ServiceException("用户名或密码错误");
		}
		return ResultGenerator.genSuccessResult(userService.login(map));

	}
}