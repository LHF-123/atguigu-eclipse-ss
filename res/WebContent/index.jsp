<%@page import="com.lhf.restaurant.entity.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;" background="image/bg.jpg">
 	<c:if test="${empty uname }">
		<c:redirect url="/login.jsp">
			<c:set var="msg" value="必须登录才能访问" scope="session"/>
		</c:redirect>
	</c:if>
	<font size=6><font color="red"><c:out value="${uname }"/></font>的订单列表</font>
	<br><br>
	<table border="1px" align="center" width="400" height="300">
		<tr bgcolor="yellow" align="center">
			<th>订单号</th>
			<th>菜品名</th>
			<th>订单数</th>
			<th>配送地址</th>
			<th>操作订单</th>
		</tr>
		
 		<c:forEach 	var="order" items="${orders }">
 			<tr bgcolor="lightblue" align="center">
 				<td><a href="RestaurantServlet?action=queryOrder&oId=${order.orderId }"><c:out value="${order.orderId }"/></a></td>
 				<td><c:out value="${order.menu }"/></td>
 				<td><c:out value="${order.count }"/></td>
 				<td><c:out value="${order.address }"/></td>
 				<td><a href="RestaurantServlet?action=delOrder&oId=${order.orderId }">删除订单</a></td>
 			</tr>
 		</c:forEach>
	</table>
	<br>
	<input type="button" value="添加新订单" onclick="location='addOrder.jsp'">
</body>
</html>