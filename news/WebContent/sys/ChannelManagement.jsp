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
		function insertChannel(){
			var name = document.getElementsByName('name')[0];
			var sort = document.getElementsByName('sort')[0];
			if(name.value==''){
				alert('请输入栏目名');
				name.focus();
				return false;
			}
			if(sort.value==''){
				alert('请输入序号');
				sort.focus();
				return false;
			}
			
			//隐藏div
			$("#add_column").fadeOut(100);
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
				$("#edit_column").fadeIn(100);
			}
		}
		
		function updateChannel(){
			var name = document.getElementsByName('name')[1];
			var sort = document.getElementsByName('sort')[1];
			if(name.value==''){
				alert('请输入栏目名');
				name.focus();
				return false;
			}
			if(sort.value==''){
				alert('请输入序号');
				sort.focus();
				return false;
			}
			
			//隐藏div
			$("#edit_column").fadeOut(100);
			return true;
		}
		
		function deleteChannel(){
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
				location.href = 'deleteChannel?id='+id;
				$("#delete_column").fadeOut(100);
			}
		}
	</script>
</head>
<body>
    <!-- 栏目管理 -->
    <div class="AccountManagement_c" id="ColumnManagement_c">
        <h3>栏目管理 
            <div class="amcl fr">
                <input type="text" placeholder="用户名" class="fl" name="">
                <div class="search fl"><img src="images/search.png"></div>
            </div> 
        </h3>
        <div class="AM_ct text_center">
            <div class="AM_ct_in">
                <div class="add_btn df_btn fl" id="add_column_btn">添加</div>
                <div class="edit_btn df_btn fl" id="edit_column_btn" onclick="showUpdate()">编辑</div>
                <div class="delete_btn df_btn fl" id="delete_column_btn">删除</div>
            </div>
        </div>

        <div class="list">
            <ul class="list_h">
                <li class="b20"><label><input type="checkbox" name=""><span>序号</span></label></li>
                <li class="b80"><label>栏目名称</label></li>
            </ul>
            <div class="list_b_c">
            	<%
            	 List<Channel> list = (List<Channel>)request.getAttribute("channelList");
	             if(list==null || list.isEmpty()){
            	%>
                <ul class="list_null">
                    <li class="text_center">未添加栏目！</li>
                </ul>
				<%
	             }else{
	            	 for(Channel chnl : list){
				 %>
                <ul class="list_b">
                    <li class="b20"><label><input type="checkbox" name="ids" value="<%=chnl.getId() %>"><span><%=chnl.getSort() %></span></label></li>
                    <li class="b80"><label><%=chnl.getName() %></label></li>
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

    <!-- 添加栏目 -->
    <div class="add_Account dn" id="add_column">
    	<form action="insertChannel" method="post" onsubmit="return insertChannel();">
        <div class="add_Account_c" style="height: 260px;">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    	添加栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="name">     
            </div>
            <div class="user_password user_i">
                <label>序&emsp;号</label> <input type="text" placeholder="输入序号" name="sort">     
            </div>
            <div align="center">
           		<button type="submit" class="add_Account_ok_btn text_center" id="add_column_ok_btn">确&emsp;定</button>
           	</div>
        </div>
        </form>
    </div>

    <!-- 编辑栏目 -->
    <div class="add_Account dn" id="edit_column">
    	<form action="updateChannel" method="post" onsubmit="return updateChannel();">
    	<input type="hidden" name="id"/>
        <div class="add_Account_c" style="height: 260px;">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    	编辑栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="name">     
            </div>
            <div class="user_password user_i">
                <label>序&emsp;号</label> <input type="text" placeholder="输入序号" name="sort">     
            </div>
            <div align="center">
           		<button type="submit" class="add_Account_ok_btn text_center" id="edit_column_ok_btn">确&emsp;定</button>
           	</div>
        </div>
        </form>
    </div>

    <!-- 删除栏目 -->
    <div class="add_Account dn" id="delete_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    	删除栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除栏目吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_column_ok_btn" onclick="deleteChannel()">确&emsp;定</div>
        </div>
    </div>

</body>
</html>