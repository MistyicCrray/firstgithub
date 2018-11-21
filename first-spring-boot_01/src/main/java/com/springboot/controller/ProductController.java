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
import com.springboot.entity.Order;
import com.springboot.entity.Product;
import com.springboot.entity.User;
import com.springboot.service.OrderService;
import com.springboot.service.ProductService;
import com.springboot.service.ShoppingCartService;
import com.springboot.tools.CurrentUser;
import com.springboot.tools.LoginRequired;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
import com.springboot.tools.ServiceException;
import com.springboot.tools.TableData;
import com.springboot.tools.UUIDUtils;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShoppingCartService shoppingCartService;

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
		return ResultGenerator.genSuccessResult(productService.add(product));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result get(Integer pageNum, Integer size, Product product,
			@RequestParam(required = false) Map<String, Object> map) {
		Page<Product> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Product> list = productService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), list));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(productService.delete(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result getById(@PathVariable String id) {
//		productService.getHits(id); // 增加浏览量
		return ResultGenerator.genSuccessResult(productService.findById(id));
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map) {
		return ResultGenerator.genSuccessResult(productService.update(map));
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
		List<Product> list = productService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), list));
	}

	/**
	 * 购买
	 * 
	 * @param user
	 * @param proId
	 * @return
	 */
	@LoginRequired
	@RequestMapping(value = "/buy/{proId}", method = RequestMethod.POST)
	public Result buyProduct(@CurrentUser User user, @PathVariable String proId) {
		Product product = productService.findById(proId);
		if (product.getQuality() == 0) {
			throw new ServiceException("该商品库存为0");
		}

		// 购物车如果有购买的商品，清除购物车的商品信息
		Map<String, Object> map = new HashMap<>();
		map.put("productid", proId);
		List<Map<String, Object>> list = shoppingCartService.findList(map);
		if (list.size() != 0) {
			String id = (String) list.get(0).get("cartid");
			shoppingCartService.delete(id);
		}
		int i = product.getQuality() - 1; // 库存减一
		Map<String, Object> map1 = new HashMap<>();
		map1.put("proid", proId);
		map1.put("quality", i);
		productService.update(map1);
		// 购买时生成订单
		Order order = new Order();
		order.setSellid(user.getId()); // 卖家Id
		order.setUserid(product.getUserid()); // 买家Id
		order.setId(UUIDUtils.getOrderIdByTime()); // 订单号
		order.setCreatedate(new Date()); // 下单日期
		order.setStatus("0");
		orderService.add(order);
		return ResultGenerator.genSuccessResult("success");
	}
}
