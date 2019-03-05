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
				if (param.get("userid") != null) {
					SET("userid=#{userid}");
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
				if (param.get("updateby") != null) {
					SET("updateby=#{updateby}");
				}
				if (param.get("status") != null) {
					SET("status=#{status}");
				}
				if (param.get("isNotAuction") != null) {
					SET("isNotAuction=#{isNotAuction}");
				}
				if (param.get("increments") != null) {
					SET("increments=#{increments}");
				}
				if (param.get("currentBidder") != null) {
					SET("currentBidder=#{currentBidder}");
				}
				if (param.get("bidderId") != null) {
					SET("bidderId=#{bidderId}");
				}
				if (param.get("auctionStatus") != null) {
					SET("auctionStatus=#{auctionStatus}");
				}
				if (param.get("outTime") != null) {
					SET("outTime=#{outTime}");
				}
				WHERE("proid=#{proid}");
			}
		}.toString();
	}

	// 类别查询
	public String selectProvider(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("product");
				if (param.get("proid") != null) {
					WHERE("proid=#{proid}");
				}
				if (param.get("name") != null) {
					WHERE("name=#{name}");
				}
				if (param.get("cateid") != null) {
					// 父类别和子类别同时查询
					WHERE("category=ANY(SELECT ID FROM CATEGORY WHERE PARENTID=#{cateid}) OR category=#{cateid}");
				}
				if (param.get("price") != null) {
					WHERE("price=#{price}");
				}
				if (param.get("color") != null) {
					WHERE("color=#{color}");
				}
				if (param.get("userid") != null) {
					WHERE("userid=#{userid}");
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
				if (param.get("isNotAuction") != null) {
					WHERE("isNotAuction=#{isNotAuction}");
				}
				if (param.get("increments") != null) {
					WHERE("increments=#{increments}");
				}
				if (param.get("currentBidder") != null) {
					WHERE("currentBidder=#{currentBidder}");
				}
				if (param.get("bidderId") != null) {
					WHERE("bidderId=#{bidderId}");
				}
				if (param.get("auctionStatus") != null) {
					WHERE("auctionStatus=#{auctionStatus}");
				}
				if (param.get("outTime") != null) {
					WHERE("outTime=#{outTime}");
				}
			}
		}.toString();
	}

	public String searchList(String key) {
		return new SQL() {
			{
				SELECT("*");
				FROM("product");
				WHERE("proid LIKE '%" + key + "%' OR" + " name LIKE '%" + key
						+ "%' OR category=(SELECT ID FROM CATEGORY WHERE name LIKE '%" + key + "%') OR detail LIKE '%"
						+ key + "%'");
			}
		}.toString();
	}

}
