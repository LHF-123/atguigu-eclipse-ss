package com.atguigu.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RequestMapping注解可以添加到类上，也可以添加到方法上
@RequestMapping("/user")
@Controller
public class HelloWorld {
	
	/*
	 * 	方法的返回值会被SpringMVC配置文件中配置的InternalResourceViewResolver这个视图解析器解析为真实的物理视图
	 * 	然后自动进行请求的转发
	 * 	真实的物理视图 = 前缀 + 方法的返回值 + 后缀
	 * 	即：/WEB-INF/views/success.jsp
	 */
	@RequestMapping("/hello")
	public String testHelloWorld() {
		System.out.println("Hello SpringMVC!");
		return "success";
	}
	
}
