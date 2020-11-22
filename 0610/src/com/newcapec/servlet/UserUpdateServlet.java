package com.newcapec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.entity.User;
import com.newcapec.service.UserService;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/updateUser")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取修改页面的数据
		int id = Integer.valueOf(request.getParameter("id"));
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		
		User updateUser = new User();
		updateUser.setId(id);
		updateUser.setRealName(realName);
		updateUser.setSex(sex);
		
		UserService userService = new UserService();
		int i = userService.updateUser(updateUser);
		
		if(i > 0) {
			request.setAttribute("updateMsg", "修改成功");
		}else {
			request.setAttribute("updateMsg", "修改失败");
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
