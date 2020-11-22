<%@page import="com.llq.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
<!-- 
	<%
		Student student = (Student)request.getAttribute("student");
	%>
 -->
	<form action="StudentServlet?action=updateStudent" method="post">
		学号：<input type="text" name="sno" value="${student.sno }" readonly="readonly"/><br>
		姓名：<input type="text" name="sname" value="${student.sname }"/><br>
		年龄：<input type="text" name="sage" value="${student.sage }"/><br>
		地址：<input type="text" name="saddress" value="${student.saddress }"/><br>
		<input type="submit" value="更改"/>
		<input type="button" value="返回" onclick="location='StudentServlet?action=queryAllStudent'"/><br>
	</form>
</body>
</html>