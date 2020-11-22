package com.lhf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/login.jsp")
public class HelloFilter implements Filter {

	public void destroy() {
		System.out.println("停止工作，消亡...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("正在进行过滤...");
		HttpServletRequest req =(HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uname = "lhf";
		if(uname.equals("lhf")) {
			chain.doFilter(request, response);//表示放行，通过设定的过滤
		}else {
			req.setAttribute("msg", "你没有通过审核不能访问！");
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
			
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("开始工作，生成...");
	}

}
