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
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("userid") != null) {
						WHERE("userid=#{userid}");
					}
					if (map.get("sellid") != null) {
						WHERE("sellid=#{sellid}");
					}
					if (map.get("status") != null) {
						WHERE("status=#{status}");
					}
					if (map.get("create_time") != null) {
						WHERE("create_time=#{create_time}");
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
					if (map.get("userid") != null) {
						SET("userid=#{userid}");
					}
					if (map.get("sellid") != null) {
						SET("sellid=#{sellid}");
					}
					if (map.get("status") != null) {
						SET("status=#{status}");
					}
					if (map.get("updateTime") != null) {
						SET("update_time=#{updateTime}");
					}
					if (map.get("confirmTime") != null) {
						SET("confirm_time=#{confirmTime}");
					}
					if (map.get("status") != null) {
						SET("status=#{status}");
					}
					if (map.get("addressId") != null) {
						SET("address_id=#{addressId}");
					}
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
