<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<form action="StudentServlet?action=addStudent" method="post">
		学号：<input type="text" name="sno"/><br>
		姓名：<input type="text" name="sname"/><br>
		年龄：<input type="text" name="sage"/><br>
		地址：<input type="text" name="saddress"/><br>
		<input type="submit" value="添加"/>
		<input type="button" value="返回" onclick="location='StudentServlet?action=queryAllStudent'"/><br>
	</form>
</body>
</html>