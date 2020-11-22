<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
//		Integer count = (Integer)session.getAttribute("count");
		Integer count = (Integer)application.getAttribute("count");
		if(count == null){//第一次没有存放，获取的是null
//			session.setAttribute("count", 1);浏览器之间互不干扰
			application.setAttribute("count", 1);//浏览器之间互通，全局应用
			count = 1;
		}else{
//			session.setAttribute("count", count+1);同13行
			application.setAttribute("count", count+1);
		}
	%>
	你是第<%= count %>次访问
	<%
		String name = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("uname".equals(cookie.getName())){
					name = cookie.getValue();
				}
			}
		}
	%>
	
	<%
		String message = "";
		String msg = (String)request.getAttribute("msg");
		if(msg != null){
			message = msg;
		}
	%>
	<h1>登录</h1>
	<font color="red"><b><%= message %></b></font>
	<form action="check1.jsp" method="post">
		用户名：<input type="text" name="uname" value="<%=name %>"/><br>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd"/><br>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>