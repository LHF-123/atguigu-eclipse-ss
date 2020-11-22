package com.atguigu.team.service;

/*
 * (1)继承Throwable或他的子类
 * (2)构造器
 * 		尽量保留两个
 * (3)必须手动throw
 */
public class TeamException extends Exception{

	public TeamException() {
		super();
	}

	public TeamException(String message) {
		super(message);
	}

	
	
}
