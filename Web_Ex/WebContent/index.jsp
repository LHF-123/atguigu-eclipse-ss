<%@page import="com.atguigu.bean.User"%>
<%@page import="java.util.List"%>
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
 	<c:if test="${empty user }">
		<c:redirect url="/login.jsp">
			<c:set var="msg" value="必须登录才能访问" scope="session"/>
		</c:redirect>
	</c:if>
	<font size=6><font color="red"><c:out value="${user.uname }"/></font>的用户列表</font>
	<br><font size=6>当前在线人数
	<span style="color:red"><c:out value="${applicationScope.count }"/></span>人</font>
	<br>
	<font size=6><font color="red"><a href="LoginServlet?action=exit">注销</a></font>
	<br><br>
	<table border="1px" align="center" width="400" height="300">
		<tr bgcolor="yellow" align="center">
			<th>用户ID</th>
			<th>用户名</th>
			<th>密码</th>
		</tr>
		
 		<c:forEach 	var="user1" items="${users }">
 			<tr bgcolor="lightblue" align="center">
 				<td><c:out value="${user1.id }"/></td>
 				<td><c:out value="${user1.uname }"/></td>
 				<td><c:out value="${user1.upwd }"/></td>
 			</tr>
 		</c:forEach>
	</table>
	<br>
</body>
</html>