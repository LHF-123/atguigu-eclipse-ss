<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="main.jsp" method="get">
		<table>
			<tr>
				<td>
				用户名：
				</td>
				<td>
				<input type="text" name="uname">
				</td>
			</tr>
			<tr>
				<td>
				密码：
				</td>
				<td>
				<input type="password" name="upwd">
				</td>
			</tr>
			<tr>
				<td>
				年龄：
				</td>
				<td>
				<input type="password" name="uage">
				</td>
			</tr>
			<tr>
				<td colspan="2">
				爱好：<br>
				<input type="checkbox" name="uhobbies" value="足球"/>足球
				<input type="checkbox" name="uhobbies" value="篮球"/>篮球
				<input type="checkbox" name="uhobbies" value="乒乓球"/>乒乓球
				</td>
			</tr>
			<tr>
				<td align="right">
				<input type="submit" value="注册">
				</td>
				<td align="left">
				<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>