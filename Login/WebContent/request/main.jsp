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
	//防盗链接
	System.out.println("request.getQueryString():" + request.getQueryString());
	String referer = request.getHeader("Referer");//Referer这个请求头是null，表示直接在地址栏中输入。如果是页面跳转，则是跳转过来的路径
	if(null == referer || !referer.contains("localhost"))
		response.sendRedirect("https://www.baidu.com/");
	else
		out.println("欢迎使用！");
	%>
</body>
</html>