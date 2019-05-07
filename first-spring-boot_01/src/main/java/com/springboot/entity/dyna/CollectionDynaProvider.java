package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CollectionDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("tc.userId,tc.collectionId as collectionid,tp.proid as proid,tp.isNotAuction as isnotauction,tp.name as pname,tp.price,tp.img as img,tu.username as username");
				FROM("t_collection tc");
				LEFT_OUTER_JOIN("t_user tu ON tu.id=tc.userId");
				LEFT_OUTER_JOIN("t_product tp ON tp.proid=tc.productId");
				if (map != null) {
					if (map.get("collectionId") != null) {
						WHERE("tc.collectionId=#{collectionId}");
					}
					if (map.get("userId") != null) {
						WHERE("tc.userId=#{userId}");
					}
					if (map.get("productId") != null) {
						WHERE("tc.productId=#{productId}");
					}
				}
			}
		}.toString();
	}
}
