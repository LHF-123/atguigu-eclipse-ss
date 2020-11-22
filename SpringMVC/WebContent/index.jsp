<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	alert($);
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/user/hello">Hello SpringMVC</a><br>
	<a href="${pageContext.request.contextPath }/testValue">Test Value</a><br>
	<a href="${pageContext.request.contextPath }/testMethod">Test Method</a><br>
	
	<form action="${pageContext.request.contextPath }/testMethod" method="post">
		<input type="submit" value="Test Method">
	</form>
	
	<a href="${pageContext.request.contextPath }/testRequestParam?username=admin">
	Test RequestParam</a><br>
	
	<form action="${pageContext.request.contextPath }/testPOJO" method="post">
		员工工号：<input type="text" name="id"><br>
		员工姓名：<input type="text" name="lastName"><br>
		员工邮箱：<input type="text" name="email"><br>
		部门编号：<input type="text" name="dept.id"><br>
		部门名称：<input type="text" name="dept.name"><br>
		<input type="submit" value="Test POJO">
	</form>
	
	<a href="${pageContext.request.contextPath }/testServletAPI?username=admin">
	Test ServletAPI</a><br>
	<a href="${pageContext.request.contextPath }/testModelAndView">Test ModelAndView</a><br>
	<a href="${pageContext.request.contextPath }/testMap">Test Map</a><br>
	<a href="${pageContext.request.contextPath }/testResponseBody">Test ResponseBody</a><br>
	<a href="${pageContext.request.contextPath }/testRedirect">Test Redirect</a><br>
</body>
</html>