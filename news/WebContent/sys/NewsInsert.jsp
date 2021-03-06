<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.news.pojo.*,java.util.*"%>
<html>
<head>
	<!-- 富文本编辑器 -->
	<script src="assets/jquery.min.js"></script>
	<script src="assets/trumbowyg.js"></script>
	<script src="assets/plugins/base64/trumbowyg.base64.js"></script>
	<link rel="stylesheet" href="assets/design/css/trumbowyg.css">
	<!--[if IE]>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
	<![endif]-->
	<base href="<%=request.getContextPath()%>/">
	<title></title>
	<meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet">
    <script type="text/javascript">
	    function insertNews(){
			var title = document.getElementsByName('title')[0];
			var chnl_code = document.getElementsByName('chnl_code')[0];
			var detail = document.getElementsByName('detail')[0];
			if(title.value==''){
				alert('请输入新闻标题');
				title.focus();
				return false;
			}
			if(chnl_code.options[chnl_code.selectedIndex].value==-1){
				alert('请选择新闻栏目');
				chnl_code.focus();
				return false;
			}
			if(detail.value==''){
				alert('请输入新闻正文');
				detail.focus();
				return false;
			}
			return true;
		}
    </script>
</head>
<body>
  <!-- 新闻新增 -->
  <div class="AccountManagement_c" id="NewsManagement_c">
      <div class="list" id="release_news">
          <ul class="list_h">
              <li class="b80"><label>发布新闻</label></li>
          </ul>
          <div class="list_b_c" id="release_news_in">
          	  <form action="insertNews" method="post" onsubmit="return insertNews();">
              <div class="release_news">
                  <div class="news_title">
                      <label class="text_center">标题</label>
                      <input type="text" placeholder="填写标题" name="title">
                  </div>
                  <div class="column_name">
                      <label class="text_center">栏目</label>
                      <select class="column_name_release" name="chnl_code">
                      	 <%
                      	 List<Channel> list = (List<Channel>)request.getAttribute("channelList");
         	             if(list==null || list.isEmpty()){
                      	 %>
                         <option value="-1">未添加栏目</option>
                         <%
			             }else{
			            	 for(Channel chnl : list){
						 %>
						 <option value="<%=chnl.getId() %>"><%=chnl.getName() %></option>
						 <%}} %>
                      </select>
                  </div>
                  <!-- 富文本编辑器 -->
                  <div id="odiv" style="display:none;position:absolute;z-index:100;">
			   	  <img src="assets/pic/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);"/>
			      <img src="assets/pic/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)"/>
			      <img src="assets/pic/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)"/>
			      <img src="assets/pic/sc.png" title="删除" border="0" alt="删除" onclick="del();odiv.style.display='none';"/>
				  </div>
				  <div  onmousedown="show_element(event)" style="clear:both" id="customized-buttonpane" class="editor"></div>  
	           	  <div><button type="submit" class="release_news_ok_btn text_center">发&emsp;布</button></div>
              </div>
              </form>
          </div>
      </div>
  </div>
  
  
</body>
</html>