<%@page import="com.lhf.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${3+5 }
	<h1>通过EL获取cookie中的值</h1>
	${cookie.user.name } : ${cookie.user.value }<br>
	<!-- 左边为user的key值，右边为user的value值 -->
	${cookie.pwd.name } : ${cookie.pwd.value }
	<br>
	<h1>通过Java获取bean中的值</h1>
	<%
		Student stu = (Student)request.getAttribute("student");
		out.print(stu.getSno() + "<br>");
		out.print(stu.getSname() + "<br>");
		out.print(stu.getSage() + "<br>");
		out.print(stu.getSaddress() + "<br>");
	%>
	<h1>通过EL获取bean中的值</h1>
	学号：${requestScope.student.sno }<br>
	姓名：${student.sname }<br>
	年龄：${student.sage }<br>
	地址：${student.saddress }<br>
	<!-- 此处的student是在ElInitServlet中放入request中的student 
		上面后三行省略了requestScope. 总共有四个域：pageScope、requestScope、sessionScope、applicationScope
		如果省略，则会从page -> request -> session -> application的顺序，进行查找，找到就显示，找不到就不显示
		注意：如果不存在，不会显示null，而是显示空！
	-->
	
	<h1>通过EL获取map中的值</h1>
	${requestScope.map.name }<br>
	
	<%=pageContext.getRequest().getRemoteAddr() %><br>
	${pageContext.request.remoteAddr }
	
	<h1>通过EL获取URL参数的值</h1>
	${param.username }<br>
	${param.password }<br>
	${param['username'] }<br>
	${param["password"] }<br>
	${paramValues.p[0] }
	${paramValues.p[1] }
	
</body>
</html>