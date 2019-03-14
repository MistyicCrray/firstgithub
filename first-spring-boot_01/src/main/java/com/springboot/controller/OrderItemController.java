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
import com.springboot.entity.OrderItem;
import com.springboot.entity.Product;
import com.springboot.entity.User;
import com.springboot.service.AddressService;
import com.springboot.service.OrderItemService;
import com.springboot.service.ProductService;
import com.springboot.service.UserService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.TableData;

@RestController
@RequestMapping("/order")
public class OrderItemController {

	@Autowired
	private OrderItemService orderItemService;

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
	public Result add(@ModelAttribute OrderItem orderItem, @CurrentUser User user) {
		orderItem.setUserid(user.getId());
		orderItem.setCreateTime(new Date());
		return ResultGenerator.genSuccessResult(orderItemService.add(orderItem));
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
		return ResultGenerator.genSuccessResult(orderItemService.delete(id));
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
		return ResultGenerator.genSuccessResult(orderItemService.update(map));
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
		if (user.getUsertype().equals("0")) {
			map.put("userid", user.getId());
			// 管理员
		} else if (user.getUsertype().equals("1")) {
			map.remove("userid");
		} else {
			return ResultGenerator.genFailResult("您无权访问");
		}
		Page<Map<String, Object>> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size,
				"create_time DESC");
		List<Map<String, Object>> list = orderItemService.findListBy(map);

		return ResultGenerator.genSuccessResult(new TableData<Map<String, Object>>(page.getTotal(), list));
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
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		OrderItem orderitem = orderItemService.findById(id);
		Product product = productService.findById(orderitem.getProductid());
		User sell = userService.findById(orderitem.getSellid()); // 卖家
		User buy = userService.findById(orderitem.getUserid()); // 买家
		Address address = addressService.findById(orderitem.getAddressId());
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("product", product);
		orderMap.put("seller", sell);
		orderMap.put("buyer", buy);
		orderMap.put("address", address);
		orderMap.put("order", orderitem);

		return ResultGenerator.genSuccessResult(orderMap);
	}

}