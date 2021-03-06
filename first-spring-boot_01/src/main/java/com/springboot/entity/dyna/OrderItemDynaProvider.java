package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class OrderItemDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_order_item");
				if (map != null) {
					if (map.get("orderId") != null) {
						WHERE("order_id=#{orderId}");
					}
					if (map.get("userid") != null) {
						WHERE("userid=#{userid}");
					}
					if (map.get("orderItemId") != null) {
						WHERE("order_item_id=#{orderItemId}");
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
				UPDATE("t_order_item");
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
				WHERE("order_item_id=#{orderItemId}");
			}
		}.toString();
	}

	public String selectBySql(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("o.order_id, o.order_item_id, o.create_time, o.quantity, o.sellid"
						+ ", o.payment, o.status, u.username,p.proid, p.name, p.isNotAuction" + ", p.price, p.img,a.*");
				FROM("t_order_item o");
				LEFT_OUTER_JOIN("t_user u ON u.id=o.userid");
				LEFT_OUTER_JOIN("t_product p ON p.proid=o.productid");
				LEFT_OUTER_JOIN("t_address a ON o.address_id=a.addrid");
				if (map != null) {
					if (map.get("orderId") != null) {
						WHERE("o.order_id=#{orderId}");
					}
					if (map.get("orderItemId") != null) {
						WHERE("o.order_item_id=#{orderItemId}");
					}
					if (map.get("userid") != null) {
						WHERE("o.userid=#{userid}");
					}
					if (map.get("sellid") != null) {
						WHERE("o.sellid=#{sellid} or o.userid=#{userid}");
					}
					if (map.get("status") != null) {
						WHERE("o.status=#{status}");
					}
					if (map.get("create_time") != null) {
						WHERE("o.create_time=#{create_time}");
					}
				}
			}
		}.toString();
	}
	
	public String select(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("o.order_id, o.order_item_id, o.create_time, o.quantity, o.sellid"
						+ ", o.payment, o.status, u.username,p.proid, p.name, p.isNotAuction" + ", p.price, p.img,a.*");
				FROM("t_order_item o");
				LEFT_OUTER_JOIN("t_user u ON u.id=o.userid");
				LEFT_OUTER_JOIN("t_product p ON p.proid=o.productid");
				LEFT_OUTER_JOIN("t_address a ON o.address_id=a.addrid");
				if (map != null) {
					if (map.get("orderId") != null) {
						WHERE("o.order_id=#{orderId}");
					}
					if (map.get("orderItemId") != null) {
						WHERE("o.order_item_id=#{orderItemId}");
					}
					if (map.get("sellid") != null) {
						WHERE("o.sellid=#{sellid} or o.userid=#{userid}");
					}
					if (map.get("status") != null) {
						WHERE("o.status=#{status}");
					}
					if (map.get("create_time") != null) {
						WHERE("o.create_time=#{create_time}");
					}
				}
			}
		}.toString();
	}
}
