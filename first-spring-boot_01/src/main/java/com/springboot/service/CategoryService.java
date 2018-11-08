package com.springboot.service;

import java.util.List;
import java.util.Map;

import com.springboot.entity.Category;

public interface CategoryService {
	int addCategory(Category category);

	int deleteCategory(String id);

	int updateCategory(Map<String, Object> map);

	List<Category> selectAll(Map<String, Object> map);

	Category selectById(String id);
}
