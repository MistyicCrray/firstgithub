package com.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.OrderItem;
import com.springboot.entity.Product;
import com.springboot.mapper.OrderItemMapper;
import com.springboot.mapper.OrderMapper;
import com.springboot.mapper.ProductMapper;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private ProductMapper productMapper;

	// 添加
	public Integer add(OrderItem orderItem) {
		return orderItemMapper.insert(orderItem);
	}

	// 删除
	public int delete(String id) {
		OrderItem orderItem = orderItemMapper.selectByPrimaryKey(id);
		Map<String, Object> map = new HashMap<>();
		map.put("orderId", orderItem.getOrderId());
		List<OrderItem> orderItemList = orderItemMapper.findList(map);
		if (orderItemList.size() > 1) {
			return orderItemMapper.deleteByPrimaryKey(id);
		} else {
			orderMapper.deleteByPrimaryKey(orderItem.getOrderId());
			return orderItemMapper.deleteByPrimaryKey(id);
		}
	}

	// 修改
	public Integer update(Map<String, Object> map) {
		OrderItem oldOrderItem = orderItemMapper.selectByPrimaryKey(map.get("orderItemId").toString());
		Product product = productMapper.selectByPrimaryKey(oldOrderItem.getProductid());
		// 如果订单取消则库存返回
		if (map.get("status").toString().equals("4")) {
			product.setQuality(oldOrderItem.getQuantity() + product.getQuality());
			// 修改
			productMapper.updateByPrimaryKey(product);
		}
		return orderItemMapper.update(map);
	}

	// 修改
	public Integer update(OrderItem orderItem) {
		return orderItemMapper.updateByPrimaryKey(orderItem);
	}

	// 查找
	public List<OrderItem> findList(Map<String, Object> map) {
		return orderItemMapper.findList(map);
	}

	// id查询
	public OrderItem findById(String id) {
		return orderItemMapper.selectByPrimaryKey(id);
	}

	public List<Map<String, Object>> findListBy(Map<String, Object> map) {
		return orderItemMapper.findListBy(map);
	}
	
	public List<Map<String, Object>> findListByOrderAndU(Map<String, Object> map) {
		return orderItemMapper.findListByOrderAndU(map);
	}

	public int getMonth(String year) {
		if (orderItemMapper.getMonth(year) == null) {
			return 0;
		}
		return orderItemMapper.getMonth(year);
	}
}
