package com.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.ShoppingCart;
import com.springboot.mapper.ShoppingCartMapper;
import com.springboot.tools.UUIDUtils;

@Service
public class ShoppingCartService {

	@Autowired
	private ShoppingCartMapper shoppingCartMapper;

	// 增加
	public int add(ShoppingCart shoppingCart) {
		shoppingCart.setId(UUIDUtils.get16UUID());
		return shoppingCartMapper.insert(shoppingCart);
	}

	// 删除
	public int delete(String id) {
		return shoppingCartMapper.deleteByPrimaryKey(id);
	}

	// 修改
	public int update(Map<String, Object> map) {
		return shoppingCartMapper.update(map);
	}

	// 查询列表
	public List<ShoppingCart> findList(Map<String, Object> map) {
		return shoppingCartMapper.findList(map);
	}

	// id查询
	public ShoppingCart findById(String id) {
		return shoppingCartMapper.selectByPrimaryKey(id);
	}
}
