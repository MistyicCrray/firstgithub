package com.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface StatisticsMapper {

	@Select({ "select COUNT(*) as num from `user`" })
	@Results({ @Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER) })
	int getUser();

	@Select({ "select COUNT(*) as num from `t_order`" })
	@Results({ @Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER) })
	int getOrder();

	@Select({ "select COUNT(*) as num from `product`" })
	@Results({ @Result(column = "num", property = "num", jdbcType = JdbcType.INTEGER) })
	int getProduct();
	
}