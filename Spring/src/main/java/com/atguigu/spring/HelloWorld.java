package com.atguigu.spring;

public class HelloWorld {
	
	private String name;
	
	public HelloWorld() {
		System.out.println("HelloWorld对象被创建了");
	}
	
	public void setName(String name) {
		System.out.println("name属性被赋值了");
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println("Hello: "+ name);
	}


}
