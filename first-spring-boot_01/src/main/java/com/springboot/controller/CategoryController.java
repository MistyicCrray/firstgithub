package com.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.entity.Category;
import com.springboot.entity.Product;
import com.springboot.service.CategoryService;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	* 类别
	* @Title: get 
	* @Description: TODO 
	* @param pageNum
	* @param size
	* @param product
	* @param map
	* @return Result
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result get(Integer pageNum, Integer size, Product product,@RequestParam Map<String, Object> map) {
		Page<Category> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 40 : size);
		List<Category> list = categoryService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Category>(page.getTotal(), list));
	}
	
	/**
	 * 添加
	* @Title: inset 
	* @Description: TODO 
	* @param category
	* @return Result
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result inset(@ModelAttribute Category category) {
		return ResultGenerator.genSuccessResult(categoryService.add(category));
	}
	
	/**
	 * 修改
	* @Title: update 
	* @Description: TODO 
	* @param map
	* @return Result
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map) {
		return ResultGenerator.genSuccessResult(categoryService.update(map));
	}
	
	/**
	 * 根据id查询
	* @Title: selectById 
	* @Description: TODO 
	* @param id
	* @return Result
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Result selectById(@PathVariable(value = "id") String id) {
		return ResultGenerator.genSuccessResult(categoryService.findById(id));
	}
}