<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lhf.login.LoginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		LoginDao loginDao = new LoginDao();
		if(loginDao.query(uname,upwd)>=1){
//			out.print("登录成功!");
//			response.sendRedirect("success.jsp");重定向：1.地址栏改变  2.相当于两次请求
			request.getRequestDispatcher("success.jsp").forward(request, response);//请求转发：1.地址栏不变   2.同一次请求
		}else
			out.print("登录失败!");
	%>
</body>
</html>