package com.springboot;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Test
	public void test1() {
		ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
		opsForValue.append("name", "zhangsan");
		System.out.println(opsForValue.get("name"));
	}

	@Test
	public void test2() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i * j + "  ");
				if (i == j) {
					System.out.println();
				}
			}
		}
	}

	@Test
	public void test3() {
		char[] jia = { 'a', 'b', 'c' };
		char[] yi = { 'x', 'y', 'z' };
		for (int i = 0; i < jia.length; i++) {
			for (int j = 0; j < yi.length; j++) {
				if (jia[i] == 'a' && yi[j] == 'x') {
					continue;
				} else if (jia[i] == 'c' && yi[j] == 'x') {
					continue;
				} else if (jia[i] == 'c' && yi[j] == 'z') {
					continue;
				} else {
					System.out.println(jia[i] + " vs " + yi[j]);
				}
			}
		}
	}

	@Test
	public void test4() {
		int x = 1;
		for (int i = 1; i <= 10; i++) {
			x = (x+1)*2;
		}
		System.out.println(x);
	}

}
