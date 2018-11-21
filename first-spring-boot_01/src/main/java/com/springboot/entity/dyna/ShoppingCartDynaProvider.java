package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ShoppingCartDynaProvider {

	public String updateProvider(Map<String, Object> param) {
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
				WHERE("cartid=#{cartid}");
			}
		}.toString();
	}

	public String selectProvider(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("shoppingcart");
				INNER_JOIN("product ON shoppingcart.productid=product.proid");
				if (param.get("quantity") != null) {
					WHERE("quantity=#{quantity}");
				}
				if (param.get("total") != null) {
					WHERE("total=#{total}");
				}
				if (param.get("ischeck") != null) {
					WHERE("shoppingcart.ischeck=#{ischeck}");
				}
				if (param.get("productid") != null) {
					WHERE("shoppingcart.productid=#{productid}");
				}
				if (param.get("userid") != null) {
					WHERE("shoppingcart.userid=#{userid}");
				}
			}
		}.toString();
	}

}
