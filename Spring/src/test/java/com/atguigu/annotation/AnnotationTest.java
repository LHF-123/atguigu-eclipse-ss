package com.atguigu.annotation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.annotation.dao.UserDao;
import com.atguigu.annotation.service.UserService;

class AnnotationTest {
	
	//创建IOC对象
	ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-annotation.xml");

	@Test
	void testUserDao() {
		UserDao userDao = (UserDao) ioc.getBean("userDaoImpl");
		System.out.println(userDao);
	}
	
	@Test
	void testUserService() {
		UserService userService = (UserService) ioc.getBean("userService");
		//调用UserService中保存用户信息的方法
		userService.saveUser();
	}

}
