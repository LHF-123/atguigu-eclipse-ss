package com.lhf.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IdeaLogin")
public class IdeaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//简单写，接收客户端的数据
		//接收一个用户名和密码
		//request：请求
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(user);
		System.out.println(pwd);
		
		//response：响应
		PrintWriter pw = response.getWriter();
		pw.println("sucess");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
