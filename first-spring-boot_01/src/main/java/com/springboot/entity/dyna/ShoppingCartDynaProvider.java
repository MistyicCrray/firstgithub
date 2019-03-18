package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ShoppingCartDynaProvider {

	public String updateProvider(Map<String, Object> param) {
		return new SQL() {
			{
				UPDATE("t_shoppingcart");
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
				FROM("t_shoppingcart");
				INNER_JOIN("t_product ON t_shoppingcart.productid=t_product.proid");
				if (param.get("quantity") != null) {
					WHERE("quantity=#{quantity}");
				}
				if (param.get("total") != null) {
					WHERE("total=#{total}");
				}
				if (param.get("ischeck") != null) {
					WHERE("t_shoppingcart.ischeck=#{ischeck}");
				}
				if (param.get("productid") != null) {
					WHERE("t_shoppingcart.productid=#{productid}");
				}
				if (param.get("userid") != null) {
					WHERE("t_shoppingcart.userid=#{userid}");
				}
			}
		}.toString();
	}
	
	public String selectBySql(Map<String, Object> param) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_shoppingcart");
				if (param.get("quantity") != null) {
					WHERE("quantity=#{quantity}");
				}
				if (param.get("total") != null) {
					WHERE("total=#{total}");
				}
				if (param.get("ischeck") != null) {
					WHERE("t_shoppingcart.ischeck=#{ischeck}");
				}
				if (param.get("productid") != null) {
					WHERE("t_shoppingcart.productid=#{productid}");
				}
				if (param.get("userid") != null) {
					WHERE("t_shoppingcart.userid=#{userid}");
				}
			}
		}.toString();
	}

}
