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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户名和密码
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		System.out.println(userName+"\t"+userPwd);
		
		//把用户名和密码给Service，Service给Dao来进行数据库查询,判断是否存在
		User loginUser = new User(userName, userPwd);
		
		UserService userService = new UserService();
		int i = userService.userLogin(loginUser);
		
		//不连接数据,如果用户名和密码是admin、admin,表示登录成功
		if(i > 0 ) {
			//如果用户登录成功,我们会在session里面放一个用户对象
			request.getSession().setAttribute("loginUser", loginUser);
			
			response.sendRedirect("sys/index.jsp");
		}else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
