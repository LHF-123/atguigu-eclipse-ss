<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="main.jsp?uname=lhf&upwd=123">进入主页</a><br>
	<%
		String addr = request.getRemoteAddr();//在地址栏输入以及通过超链接提交的都是get方式
		if(addr.equals("127.0.0.1"))
			out.print("你的IP被列入了黑名单");
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.toLowerCase().contains("chrome"))
			out.print("chrome浏览器");
		else if(userAgent.toLowerCase().contains("wow64"))
			out.print("IE浏览器");
		
	%>
</body>
</html>