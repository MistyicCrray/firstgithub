package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Category;
import com.springboot.mapper.CategoryMapper;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	public int addCategory(Category category) {
		return categoryMapper.insert(category);
	}

	public int deleteCategory(String id) {
		return categoryMapper.deleteByPrimaryKey(id);
	}

	public int updateCategory(Map<String, Object> map) {
		return categoryMapper.update(map);
	}

	public List<Category> selectAll(Map<String, Object> map) {
		return categoryMapper.findList(map);
	}

	public Category selectById(String id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

}
