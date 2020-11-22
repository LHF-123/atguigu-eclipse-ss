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
//		String name = request.getParameter("uname");这是请求转发过来的，不是重定向，获取的name为null
		String name = (String)session.getAttribute("uname");
		if(name == null){
			request.setAttribute("msg", "必须登录才能访问");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		out.print("欢迎：" + name);
	%>
</body>
</html>