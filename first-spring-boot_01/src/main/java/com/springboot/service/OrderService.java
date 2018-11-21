package com.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Order;
import com.springboot.mapper.OrderMapper;
import com.springboot.tools.ServiceException;
import com.springboot.tools.UUIDUtils;

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
	public int update(Map<String, Object> map) {
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

}
