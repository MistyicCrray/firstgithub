package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Category;
import com.springboot.mapper.CategoryMapper;
import com.springboot.tools.ServiceException;
import com.springboot.tools.UUIDUtils;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	public int addCategory(Category category) {
		category.setId(UUIDUtils.get16UUID());
		List<Category> list = categoryMapper.selectAll();
		for (Category cate : list) {
			if(category.getName().equals(cate.getName())) {
				throw new ServiceException("该类型已存在");
			}
		}
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
