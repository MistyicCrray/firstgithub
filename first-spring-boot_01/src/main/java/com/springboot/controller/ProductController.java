package com.springboot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public Result add(@ModelAttribute Product product, @CurrentUser User user,
			@RequestParam(required = false) MultipartFile file) {
		product.setCreateby(user.getUsername());
		product.setUserid(user.getId());
		product.setUpdateby(user.getId());
		return ResultGenerator.genSuccessResult(productService.add(product, file));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Result get(Integer pageNum, Integer size, Product product,
			@RequestParam(required = false) Map<String, Object> map) {
		Page<Product> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size,
				"createdate desc,hits desc");
		List<Product> list = productService.findList(map);
		return ResultGenerator.genSuccessResult(new TableData<Product>(page.getTotal(), list));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable(value = "id") String id) {
		return ResultGenerator.genSuccessResult(productService.delete(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result getById(@PathVariable String id) {
		productService.getHits(id); // 增加浏览量
		return ResultGenerator.genSuccessResult(productService.findById(id));
	}

	@LoginRequired
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User user,
			@PathVariable String id) {
		map.put("updateby", user.getId());
		map.put("proid", id);
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
	@RequestMapping(value = "/buy/{addrid}", method = RequestMethod.POST)
	public Result buyProduct(@CurrentUser User user, @RequestBody(required = false) List<Map<String, Object>> map,
			@PathVariable(value = "addrid") String addrid) {
		
		
		
		for (Map<String, Object> productMap : map) {
			Map<String, Integer> integerMap = new HashMap<>();
			integerMap.put("quality", (Integer) productMap.get("quality"));
			// integerMap.put("quantity", (Integer) productMap.get("quantity"));
			String string = productMap.get("quantity").toString();
			int i = integerMap.get("quality") - Integer.parseInt(string); // 减库存
			if (i < 0) {
				throw new ServiceException(
						"商品" + productMap.get("name") + "库存还剩余:" + productMap.get("quality") + "，请减少购买数量!");
			}
			Map<String, Object> map1 = new HashMap<>();
			if (i == 0) {
				map1.put("status", "2"); // 售罄
			}
			map1.put("proid", productMap.get("proid"));
			map1.put("quality", i);
			productService.update(map1); // 修改库存量
			Map<String, Object> shoppingMap = new HashMap<>();
			shoppingMap.put("productid", productMap.get("productid"));
			List<Map<String, Object>> list = shoppingCartService.findList(shoppingMap);
			if (list.size() != 0) {
				String id = (String) list.get(0).get("cartid");
				shoppingCartService.delete(id);
			}
			Product product = productService.findById((String) productMap.get("proid"));
			// 购买时生成订单
			Order order = new Order();
			order.setSellid(product.getUserid()); // 卖家Id
			order.setUserid(user.getId()); // 买家Id
			order.setOrderId(UUIDUtils.getOrderIdByTime()); // 订单号
			order.setCreateTime(new Date()); // 下单日期
			order.setStatus("0");
			order.setQuantity(Integer.parseInt(string)); // 数量
			order.setPayment(Integer.parseInt(string) * product.getPrice()); // 小计
			order.setProductid(product.getProid());
			order.setAddressId(addrid);
			orderService.add(order);
		}

		return ResultGenerator.genSuccessResult("success");
	}
}
