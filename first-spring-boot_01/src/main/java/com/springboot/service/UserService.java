package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.User;

public interface UserService {

	String addUser(User user, MultipartFile file);

	Map<String, Object> login(Map<String, Object> map);

	User getById(String id);

	List<User> getUsers(Map<String, Object> map);

	int updatePassword(Map<String, Object> map);
}
