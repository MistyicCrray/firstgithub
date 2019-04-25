package com.springboot.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		if (product.getQuality().equals(0)) {
			product.setStatus("2");
		} else {
			product.setStatus("0");
		}
		if (file != null) {
			product.setImg((String) FileUtil.uploadImage(file).get("filePath"));
		}
		return productMapper.insert(product);
	}

	public Integer delete(String id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	public Integer update(Map<String, Object> map, MultipartFile file) {
		// 如果当前商品为非拍卖则修改竞拍结束时间
//		if(map.get("isNotAuction").toString().equals("0")) {
//			map.put("outTime", "");
//			map.put("auctionStatus", "");
//			map.put("bidderId", "");
//			map.put("currentBidder", "");
//			map.put("increments", 0);
//			map.put("maxPrice", 0);
//			map.put("minPrice", 0);
//		}
		if (file != null) {
			map.put("img", (String) FileUtil.uploadImage(file).get("filePath"));
		} else {
			if (Integer.parseInt(map.get("quality").toString()) > 0) {
				map.put("status", 0);// 正常状态
			}
		}
		return productMapper.update(map);
	}

	public List<Product> findList(Map<String, Object> map) {
		return productMapper.findList(map);
	}

	public Product findById(String id) {
		return productMapper.selectByPrimaryKey(id);
	}

	/**
	 * 增加浏览量
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

	public List<Product> searchList(String key) {
		return productMapper.search(key);
	}

	public int delImg(String id) {
		return productMapper.deleImg(id);
	}

}
