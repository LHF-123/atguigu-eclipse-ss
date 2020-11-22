<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.news.pojo.*,java.util.*"%>
<html>
<head>
	<base href="<%=request.getContextPath()%>/">
	<title>新闻</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" type="text/css" href="css/news.css">
</head>
<body>
<div class="header_fixed">
	<div class="header text_center">
		<span class="back" onclick="history.back();" style="cursor: pointer;"><img src="images/back.png">返回</span>
		新闻 
		<span class="close">关闭</span>
	</div>
</div>

<div class="content">
	<div class="container">
		<%
		News news = (News)request.getAttribute("news");
		
		%>
		<div class="news_title">
			<h3><%=news.getTitle() %></h3>
			<div class="news_title_b"><span class="news_from">完美校园</span> <span class="news_date fr"><%=news.getUptime() %></span> </div>
		</div>	
		<div class="news_bd">
			<%=news.getDetail() %>
		</div>	
	</div>
</div>
</body>
</html>