<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		//给按钮绑定单击事件
		$("#btnId").click(function(){
			//通过$.ajax()方法发送Ajax请求
			/*
				url:必须的，设置请求地址
				type：可选的。用来设置发送请求方式，默认是get
				data：可选的，用来设置请求参数
				success:可选的，用来设置回调函数，响应成功之后系统就会自动调用该函数，
						响应数据会以参数的形式回传到该函数中
				dataType:可选的。用来设置响应的数据类型，默认是text，还可以设置xml，json等
			*/
			$.ajax({
				url:"${pageContext.request.contextPath }/AjaxServlet",
				type:"get",
				data:"username=admin&password=123456",
				success:function(res){
					//将响应信息设置到span标签中
					$("#res").text(res)
				},
				dataType:"text"
			});
		});
		
		//给第二个按钮绑定单击事件
		$("#btnId2").click(function(){
			//通过$.get./post()方法发送Ajax请求
			/*
				$.get(url, [data], [callback], [type])
					url:必须的，设置请求地址
					data：可选的，用来设置请求参数
					callback：可选的，用来设置回调函数，响应成功之后系统就会自动调用该函数，
					响应数据会以参数的形式回传到该函数中
					type：可选的，用来设置响应数据的类型
			*/
			//设置请求地址
			var url="${pageContext.request.contextPath }/AjaxServlet";
			//设置请求参数
			var params = "username=admin&password=666666";
			$.get(url,params,function(res){
				//将响应信息设置到span标签中
				$("#res2").text(res);
			},"text");
			
			//通过$.post()发送一个post请求
			//$.post(url);
		});
	});
</script>
</head>
<body>
	<h1><%=new Date() %></h1>
	<button id="btnId">通过$.ajax()方法发送Ajax请求</button>
	<span style="color:red" id="res"></span><br>
	
	<button id="btnId2">通过$.get/post()方法发送Ajax请求</button>
	<span style="color:red" id="res2"></span>
</body>
</html>