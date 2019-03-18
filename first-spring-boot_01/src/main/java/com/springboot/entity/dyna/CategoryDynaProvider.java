package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CategoryDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_category");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("parentid") != null) {
						WHERE("parentid=#{parentid}");
					}
					if (map.get("name") != null) {
						WHERE("name=#{name}");
					}
					if (map.get("type") != null) {
						WHERE("type=#{type}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_category");
				if (map.get("type") != null) {
					SET("type=#{type}");
				}
				if (map.get("parentid") != null) {
					SET("parentid=#{parentid}");
				}
				if (map.get("name") != null) {
					SET("name=#{name}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
