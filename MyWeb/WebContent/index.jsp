<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	恭喜<%= request.getParameter("uname") %>，你是第一位访客
	<font> <%=new Date() %></font>
</body>
</html>