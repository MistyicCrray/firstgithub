package com.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.Category;
import com.springboot.entity.Product;
import com.springboot.service.CategoryService;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
//	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result get(Integer pageNum, Integer size, Product product,@RequestParam Map<String, Object> map) {
		Page<Category> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 10 : size);
		List<Category> list = categoryService.selectAll(map);
		return ResultGenerator.genSuccessResult(new TableData<Category>(page.getTotal(), list));
	}
}