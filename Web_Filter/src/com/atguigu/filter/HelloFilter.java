package com.atguigu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 拦截index.jsp
 */
public class HelloFilter implements Filter {

	public void destroy() {
	}
	
	//拦截请求的方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("1、此山是我开，此树是我栽，要想从此过，留下买路财！");
		//放行请求
		chain.doFilter(request, response);
		System.out.println("5、小鬼，你又回来了");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
