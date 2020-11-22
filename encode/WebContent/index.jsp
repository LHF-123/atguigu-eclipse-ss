<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "AServlet?uname=刘">点击跳转</a>
	<form action="AServlet" method="post">
		用户名：<input type = "text" value="刘" name = "uname"/>
		<input type = "submit" value="提交"/>
	</form>
</body>
</html>