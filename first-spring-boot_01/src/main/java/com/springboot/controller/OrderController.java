package com.springboot.controller;

import java.util.Date;
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
import com.springboot.entity.Address;
import com.springboot.entity.Order;
import com.springboot.entity.Product;
import com.springboot.entity.User;
import com.springboot.service.AddressService;
import com.springboot.service.OrderService;
import com.springboot.service.ProductService;
import com.springboot.service.UserService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private UserService userService;

	/**
	 * 添加订单
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param order
	 * @param user
	 * @return Result
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@ModelAttribute Order order, @CurrentUser User user) {
		order.setUserid(user.getId());
		order.setCreateTime(new Date());
		return ResultGenerator.genSuccessResult(orderService.add(order));
	}

	/**
	 * 删除
	 * 
	 * @Title: delete
	 * @Description: TODO
	 * @param id
	 * @return Result
	 */
	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id, @CurrentUser User user) {
		return ResultGenerator.genSuccessResult(orderService.delete(id));
	}

	/**
	 * 修改
	 * 
	 * @Title: update
	 * @Description: TODO
	 * @param map
	 * @param user
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午3:32:47
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User user) {
		return ResultGenerator.genSuccessResult(orderService.update(map));
	}

	/**
	 * 列表
	 * 
	 * @Title: find
	 * @Description: TODO
	 * @param pageNum
	 * @param size
	 * @param map
	 * @param user
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午3:36:22
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result find(Integer pageNum, Integer size, @RequestParam(required = false) Map<String, Object> map,
			@CurrentUser User user) {
		map.put("userid", user.getId());
		Page<Order> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Order> list = orderService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Order>(page.getTotal(), list));
	}

	/**
	 * 查询
	 * 
	 * @Title: findById
	 * @Description: TODO
	 * @param id
	 * @param user
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午3:38:30
	 */
//	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		Order order = orderService.findById(id);
		Product product = productService.findById(order.getProductid());
		User sell = userService.findById(order.getSellid()); // 卖家
		User buy = userService.findById(order.getUserid()); // 买家
		Address address = addressService.findById(order.getAddressId());

		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("product", product);
		orderMap.put("sell", sell);
		orderMap.put("buy", buy);
		orderMap.put("address", address);
		orderMap.put("order", order);

		return ResultGenerator.genSuccessResult(orderMap);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Result findListBy(@PathVariable String id) {
		Order order = orderService.findById(id);
		Address address = addressService.findById(order.getAddressId()); // 地址信息
		Product product = productService.findById(order.getProductid()); // 商品信息
		User seller = userService.findById(order.getSellid()); // 卖家信息
		User buyer = userService.findById(order.getUserid()); // 买家信息
		buyer.setPassword("");
		seller.setPassword("");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("order", order);
		resultMap.put("address", address);
		resultMap.put("product", product);
		resultMap.put("seller", seller);
		resultMap.put("buyer", buyer);
		return ResultGenerator.genSuccessResult(resultMap);
	}

}
