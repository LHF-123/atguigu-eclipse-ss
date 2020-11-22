package com.atguigu.jedis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestJedis {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//创建Jedis对象
		Jedis jedis = new Jedis("192.168.1.100", 6379);
		//测试连接
		String ping = jedis.ping();
		System.out.println(ping);
		//向Redis中添加String类型的数据
		jedis.set("k5", "v5");
		//获取Redis中k5对应的值
		String v5 = jedis.get("k5");
		System.out.println("k7对应的值是：" + v5);
		//获取Redis中的所有的key
		Set<String> keys = jedis.keys("*");
		//遍历
		for (String key : keys) {
			System.out.println(key);
		}
		//关闭Jedis
		jedis.close();
	}

}
