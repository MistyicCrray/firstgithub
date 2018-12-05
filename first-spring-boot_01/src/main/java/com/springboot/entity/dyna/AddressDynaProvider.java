package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class AddressDynaProvider {

	public String selectProvider(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("address");
				if (param.get("userid") != null) {
					WHERE("userid=#{userid}");
				}
				if (param.get("province") != null) {
					WHERE("province=#{province}");
				}
				if (param.get("city") != null) {
					WHERE("city=#{city}");
				}
				if (param.get("region") != null) {
					WHERE("region=#{region}");
				}
				if (param.get("address") != null) {
					WHERE("address=#{address}");
				}
				if (param.get("postal") != null) {
					WHERE("postal=#{postal}");
				}
				if (param.get("consignee") != null) {
					WHERE("consignee=#{consignee}");
				}
				if (param.get("phone") != null) {
					WHERE("phone=#{phone}");
				}
				if (param.get("status") != null) {
					WHERE("status=#{status}");
				}
				if (param.get("createdate") != null) {
					WHERE("createdate=#{createdate}");
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> param) {
		return new SQL() {
			{
				UPDATE("address");
				if (param.get("province") != null) {
					SET("province=#{province}");
				}
				if (param.get("city") != null) {
					SET("city=#{city}");
				}
				if (param.get("region") != null) {
					SET("region=#{region}");
				}
				if (param.get("address") != null) {
					SET("address=#{address}");
				}
				if (param.get("postal") != null) {
					SET("postal=#{postal}");
				}
				if (param.get("consignee") != null) {
					SET("consignee=#{consignee}");
				}
				if (param.get("phone") != null) {
					SET("phone=#{phone}");
				}
				if (param.get("status") != null) {
					SET("status=#{status}");
				}
				WHERE("addrid=#{addrid}");
			}
		}.toString();
	}
}
