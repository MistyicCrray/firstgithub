package com.springboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.entity.Product;
import com.springboot.mapper.ProductMapper;
import com.springboot.service.ProductService;
import com.springboot.tools.FileUtil;
import com.springboot.tools.UUIDUtils;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	public Integer add(Product product, MultipartFile file) {
		product.setProid(UUIDUtils.get16UUID());
		product.setCreatedate(new Date());
		product.setUpdatedate(new Date());
		product.setHits(0);
		if (file != null) {
			product.setImg((String) FileUtil.uploadImage(file).get("filePath"));
		}
		return productMapper.insert(product);
	}

	public Integer delete(String id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	public Integer update(Map<String, Object> map) {
		return productMapper.update(map);
	}

	public List<Product> findList(Map<String, Object> map) {
		return productMapper.findList(map);
	}

	public Product findById(String id) {
		return productMapper.selectByPrimaryKey(id);
	}

	/**
	 * 浏览量
	 */
	public Integer getHits(String id) {
		Product product = productMapper.selectByPrimaryKey(id);
		if (product != null) {
			Integer i = product.getHits();
			if (i == null || i == 0) {
				i = 1;
			} else {
				i++;
			}
			Map<String, Object> map = new HashMap<>();
			map.put("proid", id);
			map.put("hits", i);
			return productMapper.update(map);
		}
		return 0;
	}

}
