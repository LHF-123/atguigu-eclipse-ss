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
				location.href = 'showUpdateNews?id='+id;
			}
		}
		
		function deleteNews(){
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
				location.href = 'deleteNews?id='+id;
				$("#delete_column").fadeOut(100);
			}
		}
	</script>
</head>
<body>
    <!-- 栏目管理 -->
    <div class="AccountManagement_c" id="ColumnManagement_c">
        <h3>新闻管理 
            <div class="amcl fr">
                <input type="text" placeholder="用户名" class="fl" name="">
                <div class="search fl"><img src="images/search.png"></div>
            </div> 
        </h3>
        <div class="AM_ct text_center">
            <div class="AM_ct_in">
                <div class="add_btn df_btn fl" id="add_column_btn" onclick="location.href='showInsertNews'">添加</div>
                <div class="edit_btn df_btn fl" id="edit_column_btn" onclick="showUpdate()">编辑</div>
                <div class="delete_btn df_btn fl" id="delete_column_btn">删除</div>
            </div>
        </div>

        <div class="list">
            <ul class="list_h">
                <li class="b60"><label><input type="checkbox" name=""><span>新闻标题</span></label></li>
                <li class="b20"><label>新闻栏目</label></li>
                <li class="b20"><label>发布时间</label></li>
            </ul>
            <div class="list_b_c">
            	<%
            	 List<News> list = (List<News>)request.getAttribute("newsList");
	             if(list==null || list.isEmpty()){
            	%>
                <ul class="list_null">
                    <li class="text_center">未添加新闻！</li>
                </ul>
				<%
	             }else{
	            	 for(News news : list){
				 %>
                <ul class="list_b">
                    <li class="b60"><label><input type="checkbox" name="ids" value="<%=news.getId() %>"><span><%=news.getTitle() %></span></label></li>
                    <li class="b20"><label><%=news.getChnl_name() %></label></li>
                    <li class="b20"><label><%=news.getUptime() %></label></li>
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

    <!-- 删除新闻 -->
    <div class="add_Account dn" id="delete_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    	删除新闻
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除新闻吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_column_ok_btn" onclick="deleteNews()">确&emsp;定</div>
        </div>
    </div>

</body>
</html>