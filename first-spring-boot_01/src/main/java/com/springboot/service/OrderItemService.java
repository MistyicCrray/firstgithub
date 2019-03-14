package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.OrderItem;
import com.springboot.mapper.OrderItemMapper;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemMapper orderItemMapper;

	// 添加
	public Integer add(OrderItem orderItem) {
		return orderItemMapper.insert(orderItem);
	}

	// 删除
	public int delete(String id) {
		return orderItemMapper.deleteByPrimaryKey(id);
	}

	// 修改
	public Integer update(Map<String, Object> map) {
		return orderItemMapper.update(map);
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
}
