<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;" background="image/bg.jpg">
	<font color="red" size="7"><b>网上订餐系统</b></font>
	<br><br>
	<font color="red"><b><c:out value="${msg }"/></b></font>
	<form action="LoginServlet" method="post">
		用户名：<input type="text" name="uname"/><br>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd"/><br><br>
		<input type="submit" value="登录"/>
	</form>
	<br><br>
 	<font color="#1E90FF">学号：19171202041</font><br>
 	<font color="#1E90FF">班级：软件二班</font><br>
	<font color="#1E90FF">姓名：刘浩峰</font>
</body>
</html>