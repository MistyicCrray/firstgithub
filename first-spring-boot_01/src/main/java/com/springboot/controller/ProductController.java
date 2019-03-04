package com.springboot.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@LoginRequired
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result add(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User user,
			@RequestParam(required = false) MultipartFile file)
			throws IllegalAccessException, InvocationTargetException {
		Product product = new Product();
		product.setCreateby(user.getUsername());
		product.setUserid(user.getId());
		product.setUpdateby(user.getId());
		BeanUtils.populate(product, map);
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
		Page<Product> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size, "createdate");
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
		Order order = new Order();
		for (Map<String, Object> productMap : map) {
			Integer quantity = Integer.parseInt(productMap.get("quantity").toString());
			Integer quality = Integer.parseInt(productMap.get("quality").toString());
			int i = quality - quantity; // 减库存
			// 如果库存小于0则提醒买家
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
			order.setOrderId(UUIDUtils.getOrderIdByTime()); // 订单号
			order.setSellid(product.getUserid()); // 卖家Id
			order.setUserid(user.getId()); // 买家Id
			order.setCreateTime(new Date()); // 下单日期
			order.setStatus("0"); // 未发货待付款状态
			order.setQuantity(quantity); // 数量
			order.setPayment(quantity * product.getPrice()); // 小计
			order.setProductid(product.getProid());
			order.setAddressId(addrid);
			orderService.add(order);
		}
		return ResultGenerator.genSuccessResult(order);
	}

	/**
	 * 竞拍
	 * 
	 * @param map
	 * @param user
	 * @return
	 */
	@LoginRequired
	@RequestMapping(value = "/auction/{productId}", method = RequestMethod.PUT)
	public Result auction(@RequestBody Map<String, Object> map, @CurrentUser User user,
			@PathVariable String productId) {
		Product product = productService.findById(productId);
		if (product.getUserid().equals(user.getId())) {
			return ResultGenerator.genFailResult("您不能竞拍自己的商品");
		}
		if (product.getPrice() >= Float.parseFloat(map.get("price").toString())) {
			return ResultGenerator.genFailResult("出价不能低于当前价格");
		}
		if (product.getIncrements() > (Float.parseFloat(map.get("price").toString())-Float.parseFloat(map.get("increments").toString()))) {
			return ResultGenerator.genFailResult("加价不能低于" + product.getIncrements());
		}
		if (product.getBidderid().equals(user.getId())) {
			return ResultGenerator.genFailResult("您已经竞拍过，请勿重复竞拍");
		}
		map.put("proid", productId);
		map.put("bidderId", user.getId()); // 竞拍者id
		map.put("currentBidder", user.getUsername()); // 竞拍者姓名
		map.put("auctionStatus", "1"); // 竞拍状态
		map.put("price", Float.parseFloat(map.get("price").toString())); // 商品当前价格
		productService.update(map);
		return ResultGenerator.genSuccessResult("竞拍成功");
	}
}
