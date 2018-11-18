package com.springboot.controller;

import java.util.HashMap;
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
import com.springboot.entity.Product;
import com.springboot.entity.User;
import com.springboot.service.ProductService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * 上架
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param product
	 * @param user
	 * @return Result
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@ModelAttribute Product product, @CurrentUser User user) {
		product.setCreateby(user.getUsername());
		product.setUserid(user.getId());
		return ResultGenerator.genSuccessResult(productService.addProduct(product));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result get(Integer pageNum, Integer size, Product product,
			@RequestParam(required = false) Map<String, Object> map) {
		Page<Product> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Product> list = productService.getAll(map);
		return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), list));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(productService.deleteProduct(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result getById(@PathVariable String id) {
		productService.getHits(id);  // 增加浏览量
		return ResultGenerator.genSuccessResult(productService.getById(id));
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map) {
		return ResultGenerator.genSuccessResult(productService.updateProduct(map));
	}

	/**
	 *
	 * @Title: getByUser
	 * @Description: TODO 查询自己的上架的商品
	 * @param pageNum 当前页
	 * @param size    每页显示条数
	 * @param map
	 * @param user
	 * @return Result
	 */
	@LoginRequired
	@RequestMapping(value = "/getByUser", method = RequestMethod.GET)
	public Result getByUser(Integer pageNum, Integer size, @RequestParam(required = false) Map<String, Object> map,
			@CurrentUser User user) {
		map.put("userid", user.getId());
		Page<Product> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Product> list = productService.getAll(map);
		return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), list));
	}
	
	@LoginRequired
	@RequestMapping(value = "/buy",method = RequestMethod.POST)
	public Result buyProduct(@CurrentUser User user, @PathVariable String proId) {
		return ResultGenerator.genSuccessResult(productService.buyProduct(proId));
	}
}
