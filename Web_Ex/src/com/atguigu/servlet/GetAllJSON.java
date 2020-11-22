package com.atguigu.servlet;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;
import com.atguigu.dao.QueryUsers;
import com.google.gson.Gson;

/**
 * 
 * @author LHF
 *
 * 2020-9-8 15:33:52
 * 
 * 	通过Ajax请求查询数据库中所有用户的信息的Servlet
 */
@WebServlet("/GetAllJSON")
public class GetAllJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建QueryUsers对象
		QueryUsers qu = new QueryUsers();
		//调用获取所有用户的方法
		ArrayList<User> users = (ArrayList<User>) qu.queryAll();
		//创建Gson对象
		Gson gson = new Gson();
		//将users转换为JSON字符串
		String json = gson.toJson(users);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
