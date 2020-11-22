<%@page import="com.lhf.denglu.Vote"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lhf.denglu.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <%
        String [] dwid = request.getParameterValues("dwid");
        Login vado = new Login();
        vado.updateVotes(dwid);    
     %>
	<input type="button" value="返回" onclick="location='display.jsp'"/>
 	<table align="center" width="400" height="500">
            <caption><font size="6">投票结果展示</font></caption>
            <tr bgcolor="yellow" align="center">
                <td>编号</td>
                <td>姓名</td>
                <td>得票数</td>
            </tr>
    <%
        Login login = new Login();
        ArrayList<Vote> votes = login.getAllVotes();
        for(int i = 0; i < votes.size();i++){
               Vote vote = (Vote)votes.get(i);
     %>
            <tr bgcolor="pink" >
            <td align="center"><%=vote.getdwid() %></td>
            <td align="center"><%=vote.getdwname() %></td>
            <td align="left"> <img src="img/zhu.jpg" width="<%=vote.getdvote() %>" height="10">  <%=vote.getdvote() %></td>
            </tr>
     <%
        }
      %>
      </table>
      
      <%
      	Login close1 = new Login();
      	close1.close();
      %>
</body>
</html>