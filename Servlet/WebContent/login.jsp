<%@page import="com.lhf.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.lhf.bean.User"></jsp:useBean>
<!-- 第4行相当于new了一个新对象为user -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="index.jsp">
		用户名：<input type="text" name="username"/><br>
		密码：<input type="password" name="password"/><br>
		<input type="submit" value="中文"/>
	</form>

	<jsp:setProperty property="username" name="user" value="lhf"/>
	<jsp:setProperty property="password" name="user" value="123"/>
	<%
		User user1 = new User();
		pageContext.setAttribute("user1", user1);
	%>
	<%=user1 %><br>
	
	用户名：<jsp:getProperty property="username" name="user"/><br>
	密码：<jsp:getProperty property="password" name="user"/>
</body>
</html>