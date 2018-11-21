package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ProductDynaProvider {
	public String updateProvider(Map<String, Object> param) {
		return new SQL() {
			{
				UPDATE("product");
				
				if (param.get("name") != null) {
					SET("name=#{name}");
				}
				if (param.get("category") != null) {
					SET("category=#{category}");
				}
				if (param.get("price") != null) {
					SET("price=#{price}");
				}
				if (param.get("color") != null) {
					SET("color=#{color}");
				}
				if (param.get("userId") != null) {
					SET("userId=#{userId}");
				}
				if (param.get("quality") != null) {
					SET("quality=#{quality}");
				}
				if (param.get("hits") != null) {
					SET("hits=#{hits}");
				}
				if (param.get("maxPrice") != null) {
					SET("max_price=#{maxPrice}");
				}
				if (param.get("minPrice") != null) {
					SET("min_price=#{minPrice}");
				}
				WHERE("proid=#{proid}");
			}
		}.toString();
	}
	
	public String selectProvider(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("product");
				if (param.get("name") != null) {
					WHERE("name=#{name}");
				}
				if (param.get("category") != null) {
					WHERE("category=#{category}");
				}
				if (param.get("price") != null) {
					WHERE("price=#{price}");
				}
				if (param.get("color") != null) {
					WHERE("color=#{color}");
				}
				if (param.get("userId") != null) {
					WHERE("userId=#{userId}");
				}
				if (param.get("img") != null) {
					WHERE("img=#{img}");
				}
				if (param.get("hits") != null) {
					WHERE("hits=#{hits}");
				}
				if (param.get("minPrice") != null) {
					WHERE("min_price=#{minPrice}");
				}
				if (param.get("maxPrice") != null) {
					WHERE("max_price=#{maxPrice}");
				}
				if (param.get("quality") != null) {
					WHERE("quality=#{quality}");
				}
			}
		}.toString();
	}
}
