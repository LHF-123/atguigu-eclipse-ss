<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>修改用户信息页面</h1>
	<form action="updateUser" method="post">
		<input type="hidden" name="id" value="${updateUser.id }">
		用户名: <input type="text" name="userName" id="userName" readOnly value="${updateUser.userName }"> <br>
		姓名: <input type="text" name="realName" value="${updateUser.realName }"> <br>
		性别: 
			<c:if test="${updateUser.sex == '男' }">
				<input type="radio" value="男" name="sex" checked>男  <input type="radio" value="女" name="sex">女 
			</c:if>
			<c:if test="${updateUser.sex == '女' }">
				<input type="radio" value="男" name="sex" >男  <input type="radio" value="女" name="sex" checked>女 
			</c:if>
		<br>
		
		<button type="submit"> 保存 </button>
	</form>
</body>
</html>