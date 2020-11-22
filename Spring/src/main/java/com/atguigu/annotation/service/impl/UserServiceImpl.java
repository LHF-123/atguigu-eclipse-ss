package com.atguigu.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.atguigu.annotation.beans.User;
import com.atguigu.annotation.dao.UserDao;
import com.atguigu.annotation.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	/*
	 * 	自动装配的规则：
	 * 	1、根据属性类型实现自动装配
	 * 	2、如果根据类型无法实现自动装配，会以属性名作为id从IOC容器中寻找以实现自动装配
	 * 	3、如果通过1和2都不能实现自动装配，还可以通过@Qualifier注解的
	 * 		value属性来指定id以实现自动装配，而且value属性名可以省略
	 */
	@Qualifier("userDao1")
	@Autowired
	private UserDao userDao;
	
	/*
	 * 	添加了@Autowired注解的属性默认必须注入成功，否则会抛出异常，我们可以通过设置
	 * 		该注解的request属性的值为false来告诉Spring当前属性可以不装配
	 */
	@Autowired(required = false)
	private User user;

	@Override
	public void saveUser() {
		//调用UserDao中保存用户信息的方法
		userDao.saveUser();
		System.out.println(user);
	}
	
}
