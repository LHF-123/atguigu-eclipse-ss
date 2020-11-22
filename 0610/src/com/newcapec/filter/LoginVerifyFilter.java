package com.newcapec.filter;

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

import com.newcapec.entity.User;

/**
 * sys文件夹下面的资源,都是需要登录才可以访问的
 * 所以我们就对这个路径进行过滤拦截
 */
@WebFilter("/sys/*")
public class LoginVerifyFilter implements Filter {

    private static final ServletResponse HttpServletResponse = null;

	/**
     * Default constructor. 
     */
    public LoginVerifyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 在过滤器里面进行判断,如果没有登录,则跳转到登录页面；如果登录了，就可以直接访问了
		// 从session里面取loginUser，如果有则表示登录了，如果没有则表示没有登录
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		User loginUser = (User)req.getSession().getAttribute("loginUser");
		
		if(loginUser == null) {
			resp.sendRedirect("../login.jsp");
		}
		
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
