package com.newcapec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.service.UserService;

/**
 * Servlet implementation class UserNameUniqueServlet
 */
@WebServlet("/userNameUnique")
public class UserNameUniqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取异步请求发送过来的数据
		String userName = request.getParameter("userName");
		System.out.println("异步提交过来的用户名是："+userName);
		
		//对于ajax请求，服务器要响应一个字符串
		PrintWriter writer = response.getWriter();
		
		//把异步提交过来的用户名给service-》dao-》数据库
		UserService userService = new UserService();
		int i = userService.userNameIsExist(userName);
		
		if(i > 0) {
			writer.write("用户名已存在!");
		}else {
			writer.write("恭喜,用户名可用!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
