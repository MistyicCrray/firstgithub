package com.springboot.entity.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class UserDynaProvider {
	public String selectProvider(final Map<String, Object> map) {
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
					if (map.get("create_time") != null) {
						WHERE("create_time=#{create_time}");
					}
					if (map.get("state") != null) {
						WHERE("state=#{state}");
					}
					if (map.get("address") != null) {
						WHERE("address=#{address}");
					}
					if (map.get("phone") != null) {
						WHERE("phone=#{phone}");
					}
					if (map.get("createdate") != null) {
						WHERE("createdate=#{createdate}");
					}
					if (map.get("loginname") != null) {
						WHERE("loginname=#{loginname}");
					}
					if (map.get("email") != null) {
						WHERE("email=#{email}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(final Map<String, Object> map) {
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
				if (map.get("create_time") != null) {
					SET("create_time=#{create_time}");
				}
				if (map.get("state") != null) {
					SET("state=#{state}");
				}
				if (map.get("address") != null) {
					SET("address=#{address}");
				}
				if (map.get("phone") != null) {
					SET("phone=#{phone}");
				}
				if (map.get("createdate") != null) {
					SET("createdate=#{createdate}");
				}
				if (map.get("loginname") != null) {
					SET("loginname=#{loginname}");
				}
				if (map.get("email") != null) {
					SET("email=#{email}");
				}
			
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
