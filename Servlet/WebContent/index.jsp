<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="com.lhf.bean.User"/>
	<jsp:setProperty property="*" name="user"/>
	用户名：<jsp:getProperty property="username" name="user"/><br>
	密码：<jsp:getProperty property="password" name="user"/><br>
</body>
</html>