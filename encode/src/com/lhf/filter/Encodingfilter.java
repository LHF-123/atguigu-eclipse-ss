package com.lhf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Encodingfilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		response.setContentType("text/html; charset=utf-8");
		if(req.getMethod().equals("GET")) {//处理GET请求
//			String uname = request.getParameter("uname");不可行，原因：不可能知道每一个参数的名字
			
			EncodingRequest ef = new EncodingRequest(req);
			chain.doFilter(ef, response);
		}else if(req.getMethod().equals("POST")) {//处理POST请求
			request.setCharacterEncoding("utf-8");
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
