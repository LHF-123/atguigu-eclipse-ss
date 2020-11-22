package com.atguigu.annotation.dao.impl;

import org.springframework.stereotype.Repository;

import com.atguigu.annotation.dao.UserDao;

/*
 * 通过注解将当前类交给IOC管理之后，默认在IOC容器中对象的id是类名的首字母小写
 * 我们可以通过注解的value属性来指定该id，而且value属性名可以不写
 */
@Repository("userDao2")
//@Repository(value="userDao")
public class UserDaoImpl2 implements UserDao{

	@Override
	public void saveUser() {
		System.out.println("UserDao2正在向数据库插入用户信息...");
	}
	
}
