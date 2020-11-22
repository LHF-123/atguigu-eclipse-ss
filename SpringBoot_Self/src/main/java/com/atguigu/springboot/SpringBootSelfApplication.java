package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
 * @ComponentScan注解
 * 	-用来设置自动扫描的包，如果没有指定basePackages属性，默认扫描当前类所在的包及其子包
 */
@ComponentScan(basePackages = "com.atguigu.springboot")
@SpringBootApplication
public class SpringBootSelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSelfApplication.class, args);
	}

}
