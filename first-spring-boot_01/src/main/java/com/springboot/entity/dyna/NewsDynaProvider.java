package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class NewsDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("news");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("title") != null) {
						WHERE("title=#{title}");
					}
					if (map.get("content") != null) {
						WHERE("content=#{content}");
					}
					if (map.get("sub") != null) {
						WHERE("sub=#{sub}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("news");
				if (map.get("title") != null) {
					SET("title=#{title}");
				}
				if (map.get("content") != null) {
					SET("content=#{content}");
				}
				if (map.get("sub") != null) {
					SET("sub=#{sub}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
