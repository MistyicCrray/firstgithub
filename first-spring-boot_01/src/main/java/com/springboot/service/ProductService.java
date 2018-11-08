package com.springboot.service;

import java.util.List;
import java.util.Map;

import com.springboot.entity.Product;

public interface ProductService {
	int addProduct(Product product);

	int deleteProduct(String id);

	int updateProduct(Map<String, Object> map);

	List<Product> getAll(Map<String, Object> map);

	Product getById(String id);
	
}
