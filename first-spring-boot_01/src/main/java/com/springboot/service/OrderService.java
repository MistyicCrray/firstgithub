package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Order;
import com.springboot.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;

	// 添加
	public Integer add(Order order) {
		return orderMapper.insert(order);
	}

	// 删除
	public int delete(String id) {
		return orderMapper.deleteByPrimaryKey(id);
	}

	// 修改
	public Integer update(Map<String, Object> map) {
		return orderMapper.update(map);
	}

	// 查找
	public List<Order> findList(Map<String, Object> map) {
		return orderMapper.findList(map);
	}

	// id查询
	public Order findById(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	public List<Map<String, Object>> findListBy(Map<String, Object> map) {
		return orderMapper.findListBy(map);
	}
}
