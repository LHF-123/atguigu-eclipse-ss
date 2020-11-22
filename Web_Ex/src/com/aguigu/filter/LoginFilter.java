package com.aguigu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/index.jsp")
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//获取Session对象
//		HttpSession session = req.getSession();
//		//从session域中获取uname名
//		String user = (String) session.getAttribute("user");
//		if (user != null) {
			//已经登录，放行请求
			chain.doFilter(request, response);
//		}else {
//			//还没有登录，想request域中添加提示信息
//			req.setAttribute("msg", "该操作需要先登录");
//			//转发到登录页面
//			req.getRequestDispatcher("login.jsp").forward(request, response);
//		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
