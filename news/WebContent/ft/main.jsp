<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.news.pojo.*,java.util.*"%>
<html>
<head>
	<base href="<%=request.getContextPath()%>/">
	<title>完美校园新闻</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<link rel="stylesheet" type="text/css" href="css/news.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/news.js"></script>
</head>
<body>
	<div class="header_fixed">
		<div class="header text_center">
			新闻中心 
		</div>
	<!-- 导航 -->
	<%
	int chnl_code = (Integer)request.getAttribute("chnl_code");
   	List<Channel> channelList = (List<Channel>)request.getAttribute("channelList");
    if(channelList==null || channelList.isEmpty()){
   	%>
   	<!-- 异常页 -->
	<div class="load_error text_center">
		<img src="images/error.png">
		<div>宝宝别急哦…… <br/>点击我重新加载吖……</div>
	</div>
   	<%
    }else{
    %>
    <nav>
    	<div class="nav_scrollbar text_center">
	        <ul>
	        	<%
	        	if(chnl_code==0){
		        	for(int i=0;i<channelList.size();i++){
		        		Channel chnl = channelList.get(i);
		        		if(i==0){
	        	%>
	            <li class="nav_scrollbar_on"><a href="appQueryNews?chnl_code=<%=chnl.getId() %>"><%=chnl.getName() %></a></li>
	            <%
	        			}else{
	            %>
	            <li><a href="appQueryNews?chnl_code=<%=chnl.getId() %>"><%=chnl.getName() %></a></li>
				<%		}
		        	}
	        	}else{
	        		for(Channel chnl : channelList){
	        			if(chnl_code==chnl.getId()){
	        	%>
	            <li class="nav_scrollbar_on"><a href="appQueryNews?chnl_code=<%=chnl.getId() %>"><%=chnl.getName() %></a></li>
	            <%
	        			}else{
	            %>
	            <li><a href="appQueryNews?chnl_code=<%=chnl.getId() %>"><%=chnl.getName() %></a></li>
				<%		}
	        		}
	        	}%>
	        </ul>
	    </div>
	    <div class="nav_more text_center dn"><img src="images/nav_icon.png"></div>
    </nav>
    <% } %>
    </div>
    <%
    List<News> newsList = (List<News>)request.getAttribute("newsList");
    if(newsList==null || newsList.isEmpty()){
    %>
    <!-- 异常页 -->
	<div class="load_error text_center">
		<img src="images/error.png">
		<div>暂无新闻</div>
	</div>
    <%
    }else{
	%>
    <div class="news_list">
    	<div class="container">
    		<%
    		for(News news : newsList){
    		%>
    		<!-- 列表 i -->
	    	<div class="news_list_content">
	    		<div class="news_list_content_left fl" onclick="location.href='appGetNews?id=<%=news.getId() %>'" style="cursor: pointer;">
	    			<img src="<%=news.getMain_img() %>" alt="图片加载失败">
	    		</div>
	    		<div class="news_list_content_right fr" onclick="location.href='appGetNews?id=<%=news.getId() %>'" style="cursor: pointer;">
	    			<h3><%=news.getTitle() %></h3>
	    		</div>
    			<div class="date fr"><%=news.getUptime() %></div>
	    	</div>
			<% } %>
	    	<div class="load_more text_center">点击加载更多</div>

    	</div>
    </div>
	<% } %>
</body>
</html>