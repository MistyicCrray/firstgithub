package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class OrderDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_order");
				if (map != null) {
					if (map.get("orderId") != null) {
						WHERE("order_id=#{orderId}");
					}
					if (map.get("userId") != null) {
						WHERE("user_id=#{userId}");
					}
					if (map.get("addrId") != null) {
						WHERE("addr_id=#{addrId}");
					}
					if (map.get("payment") != null) {
						WHERE("payment=#{payment}");
					}
					if (map.get("status") != null) {
						WHERE("status=#{status}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_order");
				if (map != null) {
					if (map.get("orderId") != null) {
						SET("order_id=#{orderId}");
					}
					if (map.get("userId") != null) {
						SET("user_id=#{userId}");
					}
					if (map.get("addrId") != null) {
						SET("addr_id=#{addrId}");
					}
					if (map.get("payment") != null) {
						SET("payment=#{payment}");
					}
					if (map.get("status") != null) {
						SET("status=#{status}");
					}
				}
				WHERE("order_id=#{orderId}");
			}
		}.toString();
	}
}
