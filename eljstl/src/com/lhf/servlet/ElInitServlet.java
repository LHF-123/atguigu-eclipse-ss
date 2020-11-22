package com.lhf.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhf.bean.Student;

@WebServlet("/ElInitServlet")
public class ElInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addCookie(new Cookie("user", "lhf"));
		response.addCookie(new Cookie("pwd", "123"));
		
		Student student = new Student();//自动使用系统提供的参数为空的构造方法
		student.setSno("1001");
		student.setSname("Marry");
		student.setSage(18);
		student.setSaddress("zhengzhou");
		
		request.setAttribute("student", student);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "LHF");
		request.setAttribute("map", map);
		
		request.getSession().setAttribute("student", student);//写jstl增加的内容
		
		request.getRequestDispatcher("el.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
