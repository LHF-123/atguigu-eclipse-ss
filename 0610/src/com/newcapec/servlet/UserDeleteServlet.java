package com.newcapec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.service.UserService;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/deleteUser")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到要删除的用户的id
		int deleteId = Integer.valueOf(request.getParameter("id"));
		
		UserService userService = new UserService();
		
		int i = userService.deleteUser(deleteId);
		
		if(i > 0 ) {
			request.setAttribute("deleteMsg", "删除成功！");
		}else {
			request.setAttribute("deleteMsg", "删除失败！");
		}
		request.getRequestDispatcher("sys/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
