package com.springboot.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import com.springboot.tools.FileUtil;
import com.springboot.tools.MD5;
import com.springboot.tools.SendEmailUtil;
import com.springboot.tools.ServiceException;
import com.springboot.tools.TokenUtil;
import com.springboot.tools.UUIDUtils;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
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
	 * @Title: addUser
	 * @Description: TODO
	 * @param user
	 * @param file
	 * @return String
	 * @throws MessagingException
	 */
	public User add(User user) throws MessagingException {
		String password = user.getPassword();
		user.setPassword(MD5.md5(password));
		user.setCreateTime(new Date());
		user.setEmail(user.getLoginname());

		String activeCode = UUIDUtils.getActiveCode();
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 2); // 存入过期时间
		if (!user.getLoginname().matches("^\\w+@(\\w+\\.)+\\w+$")) {
			throw new ServiceException("邮箱不合法");
		}
		// 检测用户登录账号是否存在
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginname", user.getLoginname());
		List<User> list = userMapper.findList(map);
		if (list.size() != 0) {
			// 如果存在并且已经激活
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
				SendEmailUtil.send("点击激活邮箱：<a href='" + domain + "/active.html?id=" + list.get(0).getId()
						+ "&activeCode=" + activeCode + "'>" + domain + "/active.html?id=" + list.get(0).getId()
						+ "&activeCode=" + activeCode + "</a>该链接48小时内有效", user.getLoginname(), "激活邮箱", javaMailSender,
						form);
				userMapper.update(userMap);
				return user;
			}
		}
		user.setId(UUIDUtils.get16UUID());
		user.setActivecode(activeCode);
		user.setActivedate(now.getTime()); // 存入过期时间,两天后过期
		user.setState("4"); // 未激活状态
		user.setUsertype("0"); // 非管理员
		// 发送邮件
		SendEmailUtil.send(
				"点击激活邮箱：<a href='" + domain + "/active.html?id=" + user.getId() + "&activeCode=" + activeCode + "'>"
						+ domain + "/active.html?id=" + user.getId() + "&activeCode=" + activeCode + "</a>该链接48小时内有效",
				user.getLoginname(), "激活邮箱", javaMailSender, form);
		userMapper.insert(user);
		return user;
	}

	/**
	 * 管理员添加用户
	 */
	public int addAdmin(User user) {
		user.setId(UUIDUtils.get16UUID());
		String password = user.getPassword();
		user.setPassword(MD5.md5(password)); // md5加密
		user.setCreateTime(new Date());
		user.setEmail(user.getLoginname());
		if (!user.getUsertype().equals("1")) {
			if (!user.getLoginname().matches("^\\w+@(\\w+\\.)+\\w+$")) {
				throw new ServiceException("邮箱不合法");
			}
		}
		return userMapper.insert(user);
	}

	/**
	 * 登录信息
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @param map
	 * @return Map<String,Object>
	 */
	public Map<String, Object> login(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		User user = userMapper.findList(map).get(0);
		resultMap.put("userInfo", user); // 存入user信息
		resultMap.put("accessToken", TokenUtil.createJwtToken(user.getId())); // 存入token
		return resultMap;
	}

	/**
	 * 查询用户列表(管理员操作)
	 */
	public List<User> findList(Map<String, Object> map) {
		return userMapper.findList(map);
	}

	/**
	 * 修改密码
	 */
	public Integer updatePassword(Map<String, Object> map) {
		map.put("newPassword", MD5.md5((String) map.get("newPassword")));
		return userMapper.update(map);
	}

	/**
	 * 修改信息
	 */
	public Integer update(Map<String, Object> map, MultipartFile file) {
		if (file != null) {
			map.put("img", (String) FileUtil.uploadImage(file).get("filePath"));
		}
		if (map.get("password") != null) {
			map.put("password", MD5.md5(map.get("password").toString()));
		}
		return userMapper.update(map);
	}

	/**
	 * 通过id查询
	 */
	public User findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	// 删除
	public int delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public int updateByUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}

	/**
	 * 通过账号查询
	 */
	public User findByLoginName(String loginname) {
		return userMapper.selectByLoginName(loginname);
	}
}
