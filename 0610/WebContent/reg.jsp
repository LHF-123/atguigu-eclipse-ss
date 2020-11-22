<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 在页面中引入jQuery文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<h1>注册页面</h1>
	<span id="tipSpan"></span>
	<!-- 注册表单 -->
	<!-- action是表单提交的地址,里面写的reg就是RegServlet的地址 -->
	<form action="reg" method="post">
		用户名: <input type="text" name="userName" id="userName"> <br>
		密码: <input type="password" name="userPwd"> <br>
		姓名: <input type="text" name="realName"> <br>
		性别: <input type="radio" value="男" name="sex">男  <input type="radio" value="女" name="sex">女 <br>
		爱好: <input type="checkbox" value="足球" name="hobby"> 足球
			<input type="checkbox" value="篮球" name="hobby"> 篮球
			<input type="checkbox" value="羽毛球" name="hobby"> 羽毛球 <br>
		<button type="submit"> 注册 </button>
	</form>
	
	<script type="text/javascript">
		/* 如果项目中已经引用了jQuery，一般就不会再使用原生JS的DOM操作 */
		//js:document.getElementById("userName");
		 //jQuery获取页面id为userName的元素 $("#userName");
		//当userName输入框输入完毕,失去焦点的时候,发送ajax异步请求给后台,判断用户名是否存在
		$("#userName").blur(function(){
			//当失去焦点的时候,获取到userName的值,然后异步ajax发送给后台
			var userNameVal = $(this).val();
			//发送异步ajax请求
			$.ajax({
				//发送异步请求的地址
				url:"userNameUnique",
				//发送异步请求的方式
				type:"GET",
				//发送请求的数据
				data:"userName="+userNameVal,
				//请求发送成功之后的回调函数
				//回调函数里面的参数resp是服务器给予的响应
				success:function(resp){
					$("#tipSpan").html(resp);
					$("#tipSpan").css("color","red");
				}
			})
		});
		
		
	</script>
</body>
</html>