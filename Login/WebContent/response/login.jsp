<%@page import="java.io.PrintWriter"%>
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
//		response.setStatus(302);
//		response.setHeader("Location", "https://www.baidu.com/");
		
//		response.sendError(404,"资源存在，但不想让你访问");
//		response.getWriter().print("通过getWriter对象输出");
		
		PrintWriter out1 = response.getWriter();
		out1.print("通过getWriter对象输出");
		out.print("通过内置out对象输出");
	%>
</body>
</html>