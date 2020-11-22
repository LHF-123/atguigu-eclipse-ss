<%@page import="com.lhf.login.LoginDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//1、获取表单数据
		//处理中文问题
		request.setCharacterEncoding("utf-8");
	
		//从login.jsp获取用户名和密码
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
	//2、对用户名和密码进行校验
		LoginDao loginDao1 = new LoginDao();//从Java Resources/sec/com.lhf.Login中连接数据库
		if(loginDao1.query(name,pwd)>=1){
			//把用户名保存到cookie中，发送给客户端浏览器
			//当再次打开login.jsp时，如果cookie中有名字，直接显示到用户文本框中
			Cookie cookie = new Cookie("uname",name);
			cookie.setMaxAge(60*60*24);
			response.addCookie(cookie);
			
			//3、保存用户信息到session中，重定向到success1.jsp
//			HttpSession session2 = request.getSession();//在jsp页面中，是内置对象，直接使用session
			session.setAttribute("uname", name);
			response.sendRedirect("success1.jsp");
		}else{
			//4、登录失败，保存错误信息，转发到login.jsp
			request.setAttribute("msg", "用户名或密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
</body>
</html>