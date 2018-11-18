package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ShoppingCartDynaProvider {

	public String updateProvider(final Map<String, Object> param) {
		return new SQL() {
			{
				UPDATE("shoppingcart");
				if (param.get("quantity") != null) {
					SET("quantity=#{quantity}");
				}
				if (param.get("total") != null) {
					SET("total=#{total}");
				}
				if (param.get("ischeck") != null) {
					SET("ischeck=#{ischeck}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}

	public String selectProvider(final Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("shoppingcart");
				if (param.get("quantity") != null) {
					WHERE("quantity=#{quantity}");
				}
				if (param.get("total") != null) {
					WHERE("total=#{total}");
				}
				if (param.get("ischeck") != null) {
					WHERE("ischeck=#{ischeck}");
				}
			}
		}.toString();
	}

}
