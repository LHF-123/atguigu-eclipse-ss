<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
</head>
<body style="text-align:center;" background="image/bg.jpg">
	<font color="red" size="7"><b>用户管理系统</b></font>
	<br><br>
	<font color="red"><b><c:out value="${msg }"/></b></font>
	<form action="LoginServlet" method="post">
		用户名：<input type="text" name="uname"/><br>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd"/><br><br>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>