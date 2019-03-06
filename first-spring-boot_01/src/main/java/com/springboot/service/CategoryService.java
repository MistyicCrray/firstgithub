package com.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.StringUtil;
import com.springboot.entity.Category;
import com.springboot.mapper.CategoryMapper;
import com.springboot.tools.ServiceException;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;

	public int add(Category category) {
		int id = 1001;
		List<Category> list = categoryMapper.selectAll();
		// 当这个类型为父类型时
		if (StringUtil.isEmpty(category.getParentid())) {
			Map<String, Object> cateMap = new HashMap<>();
			cateMap.put("parentid", "0");
			List<Category> sonList = categoryMapper.findList(cateMap);
			if (list.size() == 0) {
				category.setId("1001");
				category.setParentid("0");
			} else {
				category.setId(id + sonList.size() + "");
				category.setParentid("0");
			}
			// 当这个类型为子类型时
		} else {
			Map<String, Object> cateMap = new HashMap<>();
			cateMap.put("parentid", category.getParentid());
			List<Category> sonList = categoryMapper.findList(cateMap);
			if (sonList.size() < 10) {
				category.setId(id + "0" + sonList.size());
			} else {
				category.setId(id + sonList.size() + "");
			}
		}
		for (Category cate : list) {
			if (category.getName().equals(cate.getName())) {
				throw new ServiceException("该类型已存在");
			}
		}
		return categoryMapper.insert(category);
	}

	public int delete(String id) {
		return categoryMapper.deleteByPrimaryKey(id);
	}

	public int update(Map<String, Object> map) {
		return categoryMapper.update(map);
	}

	public List<Category> findList(Map<String, Object> map) {
		return categoryMapper.findList(map);
	}

	public Category findById(String id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

}
