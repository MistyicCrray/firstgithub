package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class UserDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("user");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("username") != null) {
						WHERE("username=#{username}");
					}
					if (map.get("password") != null) {
						WHERE("password=#{password}");
					}
					if (map.get("gender") != null) {
						WHERE("gender=#{gender}");
					}
					if (map.get("img") != null) {
						WHERE("img=#{img}");
					}
					if (map.get("state") != null) {
						WHERE("state=#{state}");
					}
					if (map.get("address") != null) {
						WHERE("address=#{address}");
					}
					if (map.get("tel") != null) {
						WHERE("tel=#{tel}");
					}
					if (map.get("createdate") != null) {
						WHERE("createdate=#{createdate}");
					}
					if (map.get("loginname") != null) {
						WHERE("loginName=#{loginname}");
					}
					if (map.get("email") != null) {
						WHERE("email=#{email}");
					}
					if (map.get("activeCode") != null) {
						WHERE("activeCode=#{activeCode}");
					}
					if (map.get("activeDate") != null) {
						WHERE("activeDate=#{activeDate}");
					}
					if (map.get("usertype") != null) {
						WHERE("usertype=#{usertype}");
					}
					if (map.get("adreess") != null) {
						WHERE("adreess=#{adreess}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("user");
				if (map.get("username") != null) {
					SET("username=#{username}");
				}
				if (map.get("password") != null) {
					SET("password=#{password}");
				}
				if (map.get("gender") != null) {
					SET("gender=#{gender}");
				}
				if (map.get("img") != null) {
					SET("img=#{img}");
				}
				if (map.get("state") != null) {
					SET("state=#{state}");
				}
				if (map.get("tel") != null) {
					SET("tel=#{tel}");
				}
				if (map.get("loginname") != null) {
					SET("loginName=#{loginname}");
				}
				if (map.get("email") != null) {
					SET("email=#{email}");
				}
				if (map.get("adreess") != null) {
					SET("adreess=#{adreess}");
				}
				if (map.get("lastLoginTime") != null) {
					SET("lastLoginTime=#{lastLoginTime}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
