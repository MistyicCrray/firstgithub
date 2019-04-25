package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.StatisticsService;
import com.springboot.tools.Result;
import com.springboot.tools.ResultGenerator;
/**
 * 统计
 * @author Administrator
 *
 */
@RestController
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;

	@RequestMapping(value = "/user_statistics", method = RequestMethod.GET)
	public Result getUserQuantity() {
		return ResultGenerator.genSuccessResult(statisticsService.userQuantity());
	}

	@RequestMapping(value = "/product_statistics", method = RequestMethod.GET)
	public Result getProductQuantity() {
		return ResultGenerator.genSuccessResult(statisticsService.productQuantity());
	}

	@RequestMapping(value = "/order_statistics", method = RequestMethod.GET)
	public Result getOrderQuantity() {
		return ResultGenerator.genSuccessResult(statisticsService.orderQuantity());
	}
	

	@RequestMapping(value = "/order_payment", method = RequestMethod.GET)
	public Result getOrderPayment() {
		return ResultGenerator.genSuccessResult(statisticsService.orderPayMent());
	}
}
