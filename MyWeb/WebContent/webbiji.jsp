<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="static.jsp" %>
<%@ page errorPage="index.jsp" %>
<!-- 出错跳转到index.jsp页面 -->
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+
			":"+request.getServerPort()+path+"/";
	//request.getScheme():协议  request.getServerName():localhost
	//request.getServerPort():端口号80 request.getContextPath():项目名
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="dynamic.jsp"></jsp:include>
	<br>
	<base href="<%= basePath %>">
	<!-- 动态获取URL -->
	<%= path %>
	<br>
	<%= basePath %>
	<br>
	<!-- 源代码可见注释内容 -->
	<%-- 源代码不可见注释内容 --%>
	<%= "表达式的要求：1、<%=这三个之鉴不能有空格 2、不能用分号结束 3、表达式中不能出现多行 4、输出的内容必须是字符串类型的或能转换为字符串类型的" %>
	<br>
	<% //用来写java的代码
	String i = "标签";
	out.print(i);
	%>
	
	<%!
	int x = 4;//全局变量
	%>
	
	<%
	int x = 5;//局部变量，局部优先
	out.print(x);
	%>
	
<%-- 	<jsp:forward page="index.jsp">
		<jsp:param value="lhf" name="uname"/>
	</jsp:forward>
--%>
	<!-- forward放到login.jsp里
	forward动作实现的是请求转发，而不是重定向
	主要区别：
		请求转发：存储在request对象中的数据会被保留，并带到目标页面在中login.jsp ==>index.jsp，地址栏不改变
		重定向：数据不存在，地址栏改变 -->
	<%
	/*request.setAttribute("msg", "必须登录才能访问！");//向request域中保存错误信息，转发到login.jsp
	 *request.getRequestDispatcher("login.jsp").forward(request, response);
	 *String msg = (String)request.getAttribute("msg");//获取request域中的msg属性
	 *
	 *response.sendRedirect("success.jsp");重定向：1.地址栏改变  2.相当于两次请求
	 *request.getRequestDispatcher("success.jsp").forward(request, response);//请求转发：1.地址栏不变   2.同一次请求
	 */
	%>
</body>
</html>