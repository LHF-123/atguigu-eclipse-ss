package com.atguigu.spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class HelloWorldTest {

	@Test
	void test() {
		//1.创建IOC容器对象
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取HelloWorld对象
		HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");
		//3.调用HelloWorld中的sayHello方法
//		helloWorld.sayHello();
		
		/*
		 * 	获取bean的方式：
		 * 	1、根据名称（id属性）获取
		 * 	2、根据beanbean的类型获取
		 * 		-要求：IOC容器中该类型的bean是唯一的，否则会抛出异常
		 */
		HelloWorld helloWorld2 = ioc.getBean(HelloWorld.class);
		System.out.println(helloWorld==helloWorld2);
	}

}
