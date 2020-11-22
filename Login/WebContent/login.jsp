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
		String message = "";
		String msg = (String)request.getAttribute("msg");//获取request域中的msg属性
		if(msg != null){
			message = msg;
		}
	%>
	<font color="RED"><b><%=message %></b></font>
	<form action = "check.jsp" method = "post">
		<table>
			<tr>
			 <td align="right">用户名：</td>
			 <td><input type="text" name="uname"/></td>
			</tr>
			<tr>
			 <td align="right">密码：</td>
			 <td><input type="password" name="upwd"/></td>
			</tr>
			<tr>
			 <td align="right"><input type="submit" value="提交"/></td>
			 <td align="left"><input type="reset" value="重置"/></td>
			</tr>
		</table>
	</form>
</body>
</html>