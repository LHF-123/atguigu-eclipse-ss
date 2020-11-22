<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>保存Cookie</h1>
	<%
		Cookie cookie1 = new Cookie("uname","lhf");
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("upwd","123");
    	cookie2.setMaxAge(60*60);//设置cookie的生命周期
		response.addCookie(cookie2);
    	
    	Date date = new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
    	String currentTime = format.format(date);
    	Cookie cookie = new Cookie("lasttime",currentTime);
    	cookie.setMaxAge(60*60);
    	response.addCookie(cookie);
    	
    	Cookie[] cs = request.getCookies();
    	String str = "你是首次访问本站！";
    	if(cs != null){
    		for(Cookie c : cs){
    			if(c.getName().equals("lasttime")){
    				str = "你上次访问的时间是：" + c.getValue();
    			}
    		}
    	}
    	out.print(str);
	%>
</body>
</html>