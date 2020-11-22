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
		
		String name = request.getParameter("uname");
		if(name == null){
			request.setAttribute("msg", "必须登录才能访问！");//向request域中保存错误信息，转发到login.jsp
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
	<form action="vote.jsp" method="post">
		<center><font size="5">欢迎</font><font color="red" size="5"><%=name %></font></center>
		<br>
        <table align="center" width="400" height="500">
            <caption><font size="6">欢迎给队伍投票</font><br>
            <input type="submit" value="提交投票"></caption>
            <tr bgcolor="yellow" align="center">
                <td>编号</td>
                <td>姓名</td>
                <td>得票数</td>
                <td>投票</td>
            </tr>
    <%
        Login login = new Login();
        ArrayList<Vote> votes = login.getAllVotes();
        for(int i = 0; i < votes.size();i++){
               Vote vote = (Vote)votes.get(i);
     %>
            <tr bgcolor="pink" align="center">
            <td><%=vote.getdwid() %></td>
            <td><%=vote.getdwname() %></td>
            <td align="left"><img src="img/zhu.jpg" width="<%=vote.getdvote() %>" height="10">  <%=vote.getdvote() %></td>
            <td><input name="dwid" type="radio" value="<%=vote.getdwid()%>"></td>
            </tr>
     <%
        }
      %>
      </table>
      </form>
</body>
</html>