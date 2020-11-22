package com.newcapec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.entity.User;
import com.newcapec.service.UserService;

/**
 * Servlet implementation class UserQueryByIdServlet
 */
@WebServlet("/queryUserById")
public class UserQueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要修改用户的id，根据这个id去数据库查询用户数据
		int updateId = Integer.valueOf(request.getParameter("id"));
		
		UserService userService = new UserService();
		User updateUser = userService.queryUserById(updateId);
		System.out.println("要修改的用户信息是:"+updateUser);
		//把这个数据放在请求作用域里面，然后在updateUser.jsp页面获取
		request.setAttribute("updateUser", updateUser);
		request.getRequestDispatcher("sys/updateUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
