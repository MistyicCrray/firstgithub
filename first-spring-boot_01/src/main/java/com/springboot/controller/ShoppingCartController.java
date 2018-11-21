package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.ShoppingCart;
import com.springboot.entity.User;
import com.springboot.service.ShoppingCartService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	/**
	 * 添加购物车
	 * 
	 * @Title: add
	 * @Description: TODO
	 * @param shoppingCart
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午4:44:01
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestBody ShoppingCart shoppingCart, @CurrentUser User user) {
		// 如果购物车存在已经添加过的商品，则两个相加
		Map<String, Object> map = new HashMap<>();
		map.put("productid", shoppingCart.getProductid());
		List<Map<String, Object>> shoppingCarts = shoppingCartService.findList(map);
		Map<String, Object> shopMap = new HashMap<>();
		if(shoppingCarts.size() != 0) {
			for (Map<String, Object> shoppingCart2 : shoppingCarts) {
				if (shoppingCart.getProductid().equals(shoppingCart2.get("proid"))) {
					Map<String, Float> floatMap = new HashMap<>();
					Map<String, Integer> integerMap = new HashMap<>();
					floatMap.put("total", (Float) shoppingCart2.get("total"));
					integerMap.put("quantity", (Integer) shoppingCart2.get("quantity"));
					shopMap.put("total", floatMap.get("total")+shoppingCart.getTotal());
					shopMap.put("quantity", integerMap.get("quantity")+shoppingCart.getQuantity());
					shopMap.put("cartid", shoppingCart2.get("cartid"));
					return ResultGenerator.genSuccessResult(shoppingCartService.update(shopMap));
				}
			}
		}
		shoppingCart.setUserid(user.getId());
		return ResultGenerator.genSuccessResult(shoppingCartService.add(shoppingCart));
	}

	/**
	 * 删除购物车
	 * 
	 * @Title: delete
	 * @Description: TODO
	 * @param id
	 * @param user
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午4:47:12
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id, @CurrentUser User user) {
		return ResultGenerator.genSuccessResult(shoppingCartService.delete(id));
	}

	/**
	 * 修改
	 * 
	 * @Title: update
	 * @Description: TODO
	 * @param map
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午4:48:31
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map) {
		return ResultGenerator.genSuccessResult(shoppingCartService.update(map));
	}

	/**
	 * 查询
	 * 
	 * @Title: find
	 * @Description: TODO
	 * @param pageNum
	 * @param size
	 * @param map
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午4:52:29
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result find(Integer pageNum, Integer size, @RequestParam(required = false) Map<String, Object> map,@CurrentUser User user) {
		map.put("userid", user.getId());
		return ResultGenerator.genSuccessResult(shoppingCartService.findList(map));
	}

	/**
	 * id查询
	 * 
	 * @Title: findById
	 * @Description: TODO
	 * @param id
	 * @return Result
	 * @author hlx
	 * @date 2018年11月19日下午4:53:26
	 */
	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(shoppingCartService.findById(id));
	}

}
