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
		String name = request.getParameter("uname");
		if(name == null){
//			response.sendRedirect("login.jsp");
//			out.print("name");
			request.setAttribute("msg", "必须登录才能访问！");//向request域中保存错误信息，转发到login.jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
	
	欢迎<%=name %>
</body>
</html>