<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.min.js"></script>
</head>
<body>
	<h1>登录页面</h1>
	<!-- 注册表单 -->
	<!-- action是表单提交的地址,里面写的reg就是RegServlet的地址 -->
	<form action="login" method="post">
		用户名: <input type="text" name="userName"> <br>
		密码: <input type="password" name="userPwd"> <br>
		验证码: <input type="text" name="kaptcha" id="kaptcha" value=""/> <img src="kaptcha.jpg" id="kaptchaImage"/>  <span id="kaptchaSpan"></span> <br>
		<button type="submit"> 登录 </button>
	</form>
	
	<script type="text/javascript">    
		$(function(){    
			$('#kaptchaImage').click(function () { $(this).attr('src', 'kaptcha.jpg?' + Math.floor(Math.random()*100) ); })    
		});    
		
		$("#kaptcha").blur(function(){
			var kaptchaValue = $(this).val()
			$.ajax({
				url:"kaptchaVerify",
				type:"get",
				data:{kaptcha:kaptchaValue},
				success:function(resp){
					$("#kaptchaSpan").html(resp);
					if(resp == "验证码正确!"){
						$("#kaptchaSpan").css("color","green");
					}else{
						$("#kaptchaSpan").css("color","red");
					}
					
				}
			})
		})
</script>   
</body>
</html>