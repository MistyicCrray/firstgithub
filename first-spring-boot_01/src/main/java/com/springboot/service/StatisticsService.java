package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mapper.StatisticsMapper;

@Service
public class StatisticsService {

	@Autowired
	private StatisticsMapper staticsticsMapper;

	public int userQuantity() {
		return staticsticsMapper.getUser();
	}

	public int productQuantity() {
		return staticsticsMapper.getProduct();
	}

	public int orderQuantity() {
		return staticsticsMapper.getOrder();
	}
	
	public double orderPayMent() {
		return staticsticsMapper.getCountPayMent();
	}
	
	public int getCollection(String productid) {
		return staticsticsMapper.getCollection(productid);
	}
}
