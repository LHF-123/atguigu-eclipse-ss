<%@page import="com.lhf.restaurant.entity.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;"  background="image/bg.jpg">

	<form action="RestaurantServlet?action=updateOrder" method="post">
		<font size="6" color="red">订单详情</font><br><br>
		订单号：<input type="text" name="oId" value="${order.orderId }" readonly="readonly"/><br>
		菜品名：<input type="text" name="menu" value="${order.menu }" readonly="readonly"/><br>
		订单数：<input type="text" name="count" value="${order.count }"/><br>
		配送地址：<input type="text" name="address" value="${order.address }"><br><br>
		<input type="submit" value="更改"/>
		<input type="button" value="返回" onclick="location='RestaurantServlet?action=queryAllOrder'"/><br>
	</form>
</body>
</html>