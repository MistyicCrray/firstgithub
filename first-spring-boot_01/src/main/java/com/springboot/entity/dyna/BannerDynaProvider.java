package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class BannerDynaProvider {

	public String selectProvider(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_banner");
				if (param.get("id") != null) {
					WHERE("id=#{id}");
				}
				if (param.get("image") != null) {
					WHERE("image=#{image}");
				}
				if (param.get("isShow") != null) {
					WHERE("is_show=#{isShow}");
				}
				if (param.get("isTop") != null) {
					WHERE("is_top=#{isTop}");
				}
				if (param.get("title") != null) {
					WHERE("title=#{title}");
				}
				if (param.get("createDate") != null) {
					WHERE("create_date=#{createDate}");
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> param) {
		return new SQL() {
			{
				UPDATE("t_banner");
				if (param.get("isShow") != null) {
					SET("is_show=#{isShow}");
				}
				if (param.get("isTop") != null) {
					SET("isTop=#{isTop}");
				}
				if (param.get("image") != null) {
					SET("image=#{image}");
				}
				if (param.get("title") != null) {
					SET("title=#{title}");
				}
				if (param.get("linkUrl") != null) {
					SET("link_url=#{linkUrl}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
