package com.springboot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Product;
import com.springboot.mapper.ProductMapper;
import com.springboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	public int addProduct(Product product) {
		product.setCreatedate(new Date());
		product.setUpdatedate(new Date());
		return productMapper.insert(product);
	}

	public int deleteProduct(String id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	public int updateProduct(Map<String, Object> map) {
		return productMapper.update(map);
	}

	public List<Product> getAll(Map<String, Object> map) {
		return productMapper.findList(map);
	}

	public Product getById(String id) {
		return productMapper.selectByPrimaryKey(id);
	}

}
