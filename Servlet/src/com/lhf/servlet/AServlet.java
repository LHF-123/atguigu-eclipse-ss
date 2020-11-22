package com.lhf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		
		ServletContext context = this.getServletContext();
		String name = (String)context.getAttribute("name");
		PrintWriter writer = response.getWriter();
		writer.print(name);
		System.out.println("AServlet" + context);
		
		String param = request.getParameter("method");
		if(param == null) {
			return;
		}else if (param.equals("addUser")) {
			addUser(request,response);
		}
		else if (param.equals("delUser")) {
			delUser(request,response);
		}
		else if (param.equals("editUser")) {
			editUser(request,response);
		}
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("编辑用户...");
		
	}

	private void delUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("删除用户...");
	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("添加用户...");
	}

}
