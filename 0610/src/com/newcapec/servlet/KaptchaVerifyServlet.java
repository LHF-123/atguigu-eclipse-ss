package com.newcapec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在这个Servlet中接受异步发送过来的用户输入的验证码,然后进行判断
 */
@WebServlet("/kaptchaVerify")
public class KaptchaVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kaptcha = request.getParameter("kaptcha");
		
		//判断用户输入的验证码和图片上的验证码字符串一致
		
		//从session中获取图片验证码的值
		String kaptchaExpected=(String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		
		PrintWriter writer = response.getWriter();
		if(kaptchaExpected.equals(kaptcha)) {
			writer.write("验证码正确!");
		}else {
			writer.write("验证码错误!");
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
