<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<!--[if IE]>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
	<![endif]-->
	
	<base href="<%=request.getContextPath()%>/">
	<title>登陆</title>
	<meta charset="utf-8">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript">
		function login(){
			var acct = document.getElementById('acct');
			var pwd = document.getElementById('pwd');
			if(acct.value==''){
				alert('请输入用户名');
				acct.focus();
				return false;
			}
			if(pwd.value==''){
				alert('请输入密码');
				pwd.focus();
				return false;
			}
			return true;
		}
	</script>
<script src="js/jquery.min.js"></script>
</head>
<body>
	<div class="login_head">
		<div class="container">
			<img src="images/logo.png">
		</div>
	</div>

	<div class="login_banner">
		<div class="container">
			<div class="login">
				<form action="login" method="post" onsubmit="return login();">
                <div class="login_in">
                    <div class="login_h">后台登陆</div>
                    <div class="user_login">
                        <input type="text" id="acct" name="acct" placeholder="账号">
                        <input type="password" id="pwd" name="pwd" placeholder="密码">
                    </div>
                    <div class="img_code">
                        <input type="text" name="kaptcha" id="kaptcha" placeholder="验证码"/>
                         <img src="kaptcha.jpg" id="kaptchaImage"/> 
                          <br><br><span id="kaptchaSpan"></span>
                    </div>
                    <button type="submit" class="login_btn">登陆</button>
                </div>
                </form>
            </div>
		</div>
	</div>
	
	<div class="login_end text_center">版权所有&copy;：新开普电子股份有限公司  豫ICP备08102576号  未经授权本站内容禁止私自转载使用！</div>
	
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