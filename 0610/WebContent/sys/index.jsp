<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/0610/js/jquery.min.js"></script>

<style>
	table,td,th{
		border: 1px solid black;
		border-collapse: collapse;
		
	}
	
	table{
		width:800px;
		text-align: center;
		margin: 0 auto;
	}
	
	tr{
		height:30px;
		line-height: 30px;
	}
	
</style>
</head>
<body>
	<h1>这是新闻管理系统后台首页</h1>
	<!-- 当我点击按钮，发送异步请求，获取所有用户的信息，然后展示在index.jsp -->
	${deleteMsg} ${updateMsg }
	<table id="userTable">
		<thead>
			<tr>
				<th>编号</th>
				<th>用户名</th>
				<th>密码</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>爱好</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="userTb">
			
		</tbody>
	</table>
	
	<script type="text/javascript">
		$(function(){
			$("#userTb").html("")
			$.ajax({
				//发送异步请求的地址
				url:"/0610/queryAllUser",
				//发送异步请求的方式
				type:"GET",
				//请求发送成功之后的回调函数
				//回调函数里面的参数resp是服务器给予的响应
				success:function(resp){
					console.log(resp); //服务器想要的json字符串
					var jsArr = JSON.parse(resp);//把json字符串解析为js数组
					//遍历js数组，然后得到具体的数据
					for(var i in jsArr){
						$("#userTb").append("<tr><td>"+jsArr[i].id+"</td><td>"+jsArr[i].userName+"</td><td>"+jsArr[i].userPwd+"</td><td>"+jsArr[i].realName+"</td><td>"+jsArr[i].sex+"</td><td>"+jsArr[i].hobby+"</td><td><a href=/0610/deleteUser?id="+jsArr[i].id+">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=/0610/queryUserById?id="+jsArr[i].id+">修改</a></td></tr>");
					}
				}
			})
		})
	</script>
	
</body>
</html>