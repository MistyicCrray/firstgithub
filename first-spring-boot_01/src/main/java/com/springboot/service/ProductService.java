package com.springboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Product;
import com.springboot.mapper.ProductMapper;
import com.springboot.service.ProductService;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	public int addProduct(Product product) {
		product.setCreatedate(new Date());
		product.setUpdatedate(new Date());
		product.setHits(0);
		product.setFaver(0);
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
	
	/**
	 * 浏览量
	 */
	public void getHits(String id) {
		Product product = productMapper.selectByPrimaryKey(id);
		if(product!=null) {
			Integer i = product.getHits();
			if (i == null || i == 0) {
				i = 1;
			} else {
				i++;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			map.put("hits", i);
			productMapper.update(map);
		}
	}
	
	/**
	 * 购买商品
	 */
	public int buyProduct() {
		return 0;
	}

}
