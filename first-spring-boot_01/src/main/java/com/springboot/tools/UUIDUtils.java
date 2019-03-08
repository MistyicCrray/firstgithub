package com.springboot.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {
	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static String get16UUID() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();// 随机用以下三个随机生成器
		Random randdata = new Random();
		int data = 0;
		for (int i = 0; i < 16; i++) {
			int index = rand.nextInt(3);
			// 目的是随机生成数字，大小写字母
			switch (index) {
			case 0:
				data = randdata.nextInt(10);// 仅仅会生成0~9
				sb.append(data);
				break;
			case 1:
				data = randdata.nextInt(26) + 65;// 保证只会产生65~90之间的整数
				sb.append((char) data);
				break;
			case 2:
				data = randdata.nextInt(26) + 97;// 保证只会产生97~122之间的整数
				sb.append((char) data);
				break;
			}
		}
		String result = sb.toString();
		return result;
	}

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	public static String getOrderIdByTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate = sdf.format(new Date());
		String result = "gotowhere_";
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			result += random.nextInt(10);
		}
		return newDate + result;
	}

	/**
	 * 生成6位随机数字
	 * @return
	 */
	public static String getActiveCode() {
		// 生成六位数字验证码
		String activeCode = "";
		activeCode += (int) (Math.random() * 9 + 1);
		for (int i = 0; i < 5; i++) {
			activeCode += (int) (Math.random() * 10);
		}
		return activeCode;
	}
}
