package com.atguigu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter2 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("2、此山是我开，此树是我栽，要想从此过，留下吃的来！");
//		chain.doFilter(request, response);
		System.out.println("4、小鬼，你又零食了");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
