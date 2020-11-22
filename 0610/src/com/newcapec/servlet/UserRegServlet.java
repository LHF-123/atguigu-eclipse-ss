package com.newcapec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcapec.entity.User;
import com.newcapec.service.UserService;
import com.newcapec.utils.MD5Util;

/**
 * 用户注册的Servlet
 */
@WebServlet("/reg")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 客户端浏览器发送过来的数据都存储在request对象里面
		// 客户端浏览器发送给服务器的数据是通过key-value的映射发送的，key就是name属性的值
		// request.getParameter("name属性的值") 通过请求对象获取指定数据
		String userName = request.getParameter("userName");
		//需要加密,但是加密操作不属于Servlet,那么放在Service里面处理
		String userPwd = request.getParameter("userPwd"); 
		String realName = request.getParameter("realName");
		String sex = request.getParameter("sex");
		String hobbyArr[] = request.getParameterValues("hobby");
		//把爱好数组转换为字符串
		String hobbyStr = "";
		for(String h:hobbyArr) {
			hobbyStr = hobbyStr+h+"、";
		}
		hobbyStr = hobbyStr.substring(0, hobbyStr.length()-1);
		
		//把获取得到的数据封装成一个User对象
		User user = new User(null, userName, userPwd, realName, sex, hobbyStr);
		
		UserService userService = new UserService();
		int i = userService.userReg(user);
		if(i > 0 ) {
			response.sendRedirect("login.jsp");
		}else {
			request.getRequestDispatcher("reg.jsp").forward(request, response);
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
