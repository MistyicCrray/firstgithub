package com.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import com.springboot.tools.FileUtil;
import com.springboot.tools.MD5;
import com.springboot.tools.ServiceException;
import com.springboot.tools.TokenUtil;
import com.springboot.tools.UUIDUtils;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户注册
	* @Title: addUser 
	* @Description: TODO 
	* @param user
	* @param file
	* @return String
	 */
	public String addUser(User user, MultipartFile file) {
		String password = (String) user.getPassword();
		user.setPassword(MD5.md5(password));
		user.setId(UUIDUtils.get16UUID());
		user.setState("0");
		if (file != null) {
			user.setImg("d:/data/upload/images" + (String) FileUtil.uploadImage(file).get("filePath"));
			System.out.println(user.getImg());
		}
		if (userMapper.insert(user) != 1) {
			throw new ServiceException();
		} else {
			return "success";
		}
	}

	/**
	 * 登录信息
	* @Title: login 
	* @Description: TODO 
	* @param map
	* @return Map<String,Object>
	 */
	public Map<String, Object> login(Map<String, Object> map) {

		if (userMapper.findList(map).size() == 0 || userMapper.findList(map) == null) {
			throw new ServiceException("用户名或密码错误");
		} else {
			Map<String, Object> resultMap = new HashMap<String, Object>();
			User user = userMapper.findList(map).get(0);
			resultMap.put("userInfo", user); // 存入user信息
			resultMap.put("accessToken", TokenUtil.createJwtToken(user.getId())); // 存入token
			return resultMap;
		}
	}

	/**
	 * 查询用户列表(管理员操作)
	 */
	public List<User> getUsers(Map<String, Object> map) {
		return userMapper.findList(map);
	}

	/**
	 * 修改密码
	 */
	public int updatePassword(Map<String, Object> map) {
		map.put("newPassword", MD5.md5((String) map.get("newPassword")));
		return userMapper.update(map);
	}

	/**
	 * 通过id查询
	 */
	public User getById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
