package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.UserDao;
import com.news.pojo.User;
import com.news.service.UserService;
import com.news.util.MD5Util;

public class UserLoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String acct = req.getParameter("acct");
		String pwd = req.getParameter("pwd");
		
		//UserDao dao = new UserDao();
		//User userLogin = dao.login(acct, pwd);
		
		User loginUser = new User(acct, pwd);
		
		UserService userService = new UserService();
		User userLogin = userService.userLogin(acct, pwd);
		
		//String md5Pwd = MD5Util.toMD5(pwd);
		//System.out.println("加密之后的密码是："+md5Pwd);
		
		if(userLogin != null){
			req.getSession().setAttribute("userLogin", userLogin);
			resp.sendRedirect("sys/index.jsp");
		}else{
			resp.sendRedirect("sys/login.jsp");
		}
		
		
	}
	
	
}
