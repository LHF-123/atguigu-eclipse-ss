package com.newcapec.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newcapec.entity.User;
import com.newcapec.service.UserService;

/**
 * Servlet implementation class QueryAllUserServlet
 */
@WebServlet("/queryAllUser")
public class UserQueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("接收到查询所有用户的ajax异步请求");
		
		//找Service-》Dao
		UserService userService = new UserService();
		List<User> allUsers = userService.queryAllUser();
		
		//对于异步ajax请求,我们需要反馈的是一个字符串,但是现在所有的用户存储在allUsers
		//allUsers不是一个字符串,我们就需要想办法将其转换为字符串
		//接下来就需要JSON，JSON是一种数据格式
		//gson-2.7.jar  Google提供的用来把Java对象转换为JSON字符串的第三方jar包
		Gson gson = new Gson();
		String jsonStr = gson.toJson(allUsers);
		response.getWriter().write(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
