<%@page import="com.llq.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<table border="1px">
		<tr>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>地址</th>
			<th>操作</th>
		</tr>

		<%
			List<Student> students = (List<Student>)request.getAttribute("students");
			for(Student student : students){
		%>
		<tr>
			<td><a href="StudentServlet?action=queryStudentBySno&sno=<%=student.getSno() %>"><%=student.getSno() %></a></td>
			<td><%=student.getSname() %></td>
			<td><%=student.getSage() %></td>
			<td><%=student.getSaddress() %></td>
			<td><a href="StudentServlet?action=deleteStudent&sno=<%=student.getSno() %>">删除</a></td>
		</tr>
		<%
			}
		%>
 
 		
	</table>
	<input type="button" value="添加" onclick="location='add.jsp'">
</body>
</html>