package com.lhf.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lhf.restaurant.dao.LoginDao;
import com.lhf.restaurant.entity.Order;
import com.lhf.restaurant.service.RestaurantService;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//当表单提交的参数为中文时得到的用户名是乱码，这时要设置一下编码集
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		LoginDao login1 = new LoginDao();
		if(login1.query(uname,upwd)>=1){
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			request.getRequestDispatcher("RestaurantServlet").forward(request, response);
		}else{
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
