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
import com.springboot.entity.Product;
import com.springboot.service.ProductService;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private ProductService productService;

	/**
	 * 搜索栏
	 * 
	 * @param pageNum
	 * @param size
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result search(Integer pageNum, Integer size, @RequestParam(required = false) Map<String, Object> map) {
		Page<Product> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		if (map.get("keyword") != null) {
			String key = map.get("keyword").toString();
			List<Product> produts = productService.searchList(key);
			return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), produts));
		} else {
			List<Product> produts = productService.findList(map);
			return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), produts));
		}
	}

}
