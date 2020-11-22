package com.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.dao.UserDao;
import com.news.pojo.User;

public class UserUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String acct = req.getParameter("acct");
		String pwd = req.getParameter("pwd");
		
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setAcct(acct);
		user.setPwd(pwd);
		
		UserDao dao = new UserDao();
		dao.updateUser(user);
		
		resp.sendRedirect("queryUser");
	}
	
	
}
