<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.news.pojo.*,java.util.*"%>
<html>
<head>
	<!--[if IE]>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
	<![endif]-->
	<base href="<%=request.getContextPath()%>/">
	<title></title>
	<meta charset="utf-8">
	<link href="css/main.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript">
		function insertUser(){
			var acct = document.getElementsByName('acct')[0];
			var pwd = document.getElementsByName('pwd')[0];
			var name = document.getElementsByName('name')[0];
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
			if(name.value==''){
				alert('请输入真实姓名');
				name.focus();
				return false;
			}
			//隐藏div
			$("#add_Account").fadeOut(100);
			return true;
		}
		
		function showUpdate(){
			var ids = document.getElementsByName('ids');
			var num = 0;
			var id;
			for(var i in ids){
				if(ids[i].checked){
					num++;
					id = ids[i].value;
				}
			}
			if(num==0){
				alert('请选择要编辑的数据');
			}else if(num>1){
				alert('只能编辑一条数据');
			}else{
				document.getElementsByName('id')[0].value = id;
				$("#user_column").fadeIn(100);
			}
		}
		
		function updateUser(){
			var acct = document.getElementsByName('acct')[1];
			var pwd = document.getElementsByName('pwd')[1];
			var name = document.getElementsByName('name')[1];
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
			if(name.value==''){
				alert('请输入真实姓名');
				name.focus();
				return false;
			}
			//隐藏div
			$("#user_column").fadeOut(100);
			return true;
		}
		
		function deleteUser(){
			var ids = document.getElementsByName('ids');
			var num = 0;
			var id;
			for(var i in ids){
				if(ids[i].checked){
					num++;
					id = ids[i].value;
				}
			}
			if(num==0){
				alert('请选择要删除的数据');
			}else if(num>1){
				alert('只能删除一条数据');
			}else{
				location.href = 'deleteUser?id='+id;
				$("#delete_Account").fadeOut(100);
			}
		}
	</script>
</head>
<body>
	<div class="AccountManagement_c " id="AccountManagement_c">
         <h3>账户管理 
             <div class="amcl fr">
                 <input type="text" placeholder="用户名" class="fl" name="">
                 <div class="search fl"><img src="images/search.png"></div>
             </div> 
         </h3>
         <div class="AM_ct text_center">
             <div class="AM_ct_in">
                 <div class="add_btn df_btn fl" id="add_Account_btn">添加</div>
                 <div class="edit_btn df_btn fl" id="edit_Account_btn" onclick="showUpdate()">编辑</div>
                 <div class="delete_btn df_btn fl" id="delete_Account_btn">删除</div>
             </div>
         </div>

         <div class="list">
             <ul class="list_h">
                 <li class="b20"><label><input type="checkbox" name=""><span>用户名</span></label></li>
                 <li class="b20"><label>密码</label></li>
                 <li class="b60"><label>真实姓名</label></li>
             </ul>
             <div class="list_b_c">
	             <%
	             List<User> list = (List<User>)request.getAttribute("userList");
	             if(list==null || list.isEmpty()){
	             %>
                 <ul class="list_null">
                     <li class="text_center">未添加管理员账户！</li>
                 </ul>
				 <%
	             }else{
	            	 for(User user : list){
				 %>
                 <ul class="list_b">
                     <li class="b20"><label><input type="checkbox" name="ids" value="<%=user.getId() %>"><span><%=user.getAcct() %></span></label></li>
                     <li class="b20"><label><%=user.getPwd() %></label></li>
                     <li class="b60"><label><%=user.getName() %></label></li>
                 </ul>
                 <%}} %>
             </div>

             <div class="pull_page">
                 <div class="fl pull_page_up">上一页</div>
                     <ul>
                         <li class="on">1</li>
                         <li>2</li>
                         <li>3</li>
                         <li>4</li>
                         <li class="pull_page_df_btn">…</li>
                         <li>12</li>
                     </ul>
                 <div class="fl pull_page_down">下一页</div>
             </div>
             
         </div>
     </div>

    <!-- 弹窗 -->
    <!-- 添加账户 -->
    <div class="add_Account dn" id="add_Account">
    	<form action="insertUser" method="post" onsubmit="return insertUser();">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    	添加账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="acct">     
            </div>
            <div class="user_password user_i">
                <label>密&emsp;码</label> <input type="password" placeholder="输入密码" name="pwd">     
            </div>
            <div class="user_password user_i">
                <label>真实姓名</label> <input type="text" placeholder="输入真实姓名" name="name">     
            </div>
           	<div align="center">
           		<button type="submit" class="add_Account_ok_btn text_center" id="add_Account_ok_btn">确&emsp;定</button>
           	</div>
        </div>
        </form>
    </div>

    <!-- 账户编辑 -->
    <div class="add_Account dn" id="user_column">
    	<form action="updateUser" method="post" onsubmit="return updateUser();">
    	<input type="hidden" name="id"/>
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                   		 编辑账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="acct">     
            </div>
            <div class="user_password user_i">
                <label>密&emsp;码</label> <input type="password" placeholder="输入密码" name="pwd">     
            </div>
            <div class="user_password user_i">
                <label>真实姓名</label> <input type="text" placeholder="输入真实姓名" name="name">     
            </div>
            <div align="center">
           		<button type="submit" class="add_Account_ok_btn text_center" id="user_column_ok_btn">确&emsp;定</button>
           	</div>
        </div>
        </form>
    </div>

    <!-- 删除账户 -->
    <div class="add_Account dn" id="delete_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    	删除账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除账户吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_Account_ok_btn" onclick="deleteUser()">确&emsp;定</div>
        </div>
    </div>

    <!-- 账户授权 -->
    <div class="add_Account dn" id="ac_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                   		 账户栏目授权
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <ul>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
                <li><label><input type="checkbox" name="">&nbsp;<span>教务处</span></label></li>
            </ul>
            <div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn">保<i>呀</i>存</div>
        </div>
    </div>
    
</body>
</html>