package com.atguigu.json.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.json.bean.Student;
import com.google.gson.Gson;

/**
 * 给前台响应JSON格式数据的
 */
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//假设从数据库中查询出来了一个学生信息
		Student student = new Student(1, "白骨精", 18);
		//创建Gson对象
		Gson gson = new Gson();
		//将Student对象转换为JSON对象
		String json = gson.toJson(student);
//		System.out.println(json);
		response.getWriter().write(json);
		
		//给前台响应一个JSON字符串
//		response.getWriter().write("{\"name\":\"白骨精\",\"age\":18}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
