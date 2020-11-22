<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>1. 使用jstl的out和set</h1>
	<c:out value="使用jstl输出"/><br>
	<%
		String name = "lhf";
	%>
	<%=name %><br>
	<!-- <c:out value="${name}"/> 不能输出局部变量name中的内容，不存在4个域中 -->
	
	
	<c:set var="vname" value="LHF" scope="session"/>
	<!-- 将变量vname放在sessionScope中 -->
	<c:out value="${vname }"/>	<br>
	
	<c:out value="${sessionScope.student.sno }"/>
	
	<h1>2. remove</h1>
	<%
		pageContext.setAttribute("aa", "pageContext");
		request.setAttribute("aa", "request");
		session.setAttribute("aa", "session");
		application.setAttribute("aa", "application");
	%>	
	<c:remove var="aa"/>
	<c:out value="${aa }" default="none" />
	
	<h1>3. url</h1>
	<c:url value="/jstl.jsp" />
	
	<h1>4. if</h1>
	<!-- test属性必须是一个boolean类型的数据，如果没有指定域，会在所有域中查找，也就是说全域 -->
	<c:set var="str" value="hello"/>
	<c:if test="${not empty str }">
		<c:out value="${str }"/>
	</c:if>
	
	<h1>5. choose</h1>
	<!-- 比较Java中的if...else if...else -->
	<c:set var="score" value="${param.score }"/>
	<c:choose>
		<c:when test="${score > 100 || score <0 }">错误的分数：${score }</c:when>
		<c:when test="${score >= 90 }">优秀</c:when>
		<c:when test="${score >= 80 }">良好</c:when>
		<c:when test="${score >= 70 }">中等</c:when>
		<c:when test="${score >= 60 }">及格</c:when>
		<c:otherwise>不及格</c:otherwise>
	</c:choose>
	
	<h1>6. forEach</h1>
	<!-- 使用循环控制变量，指定开始和结束 -->
	<c:set var="sum" value="0"/>
	<c:forEach var="i" begin="1" end="100" step="1">
	<!-- step表示步长，每次增加多少，不写时默认为1 -->
		<c:set var="sum" value="${sum+i }"/>
	</c:forEach>
	<c:out value="sum=${sum }"/><br><hr>
	
	<!-- 遍历数组 -->
	<%
		String[] array = {"软件01班", "软件02班", "软件03班", "软件04班"};
		pageContext.setAttribute("array", array);
	%>
	<c:forEach var="item" items="${array }">
		<c:out value="班级：${item }"/><br>
	</c:forEach>
	<hr>
	
	<!-- 遍历list -->
	<%
		List<String> names = new ArrayList<String>();
		names.add("张三");
		names.add("李四");
		names.add("王二");
		names.add("赵六");
		pageContext.setAttribute("ns", names);
	%>
	<c:forEach var="item" items="${ns }">
		<c:out value="姓名：${item }"/><br>
	</c:forEach>
	<hr>
	
	<!-- 遍历map -->
	<%
		Map<String, String> stu = new HashMap<String, String>();
		stu.put("sno", "1001");
		stu.put("sname", "lhf");
		stu.put("sage", "19");
		stu.put("saddress", "zk");
		pageContext.setAttribute("stu", stu);
	%>
	<c:forEach var="item" items="${stu }">
		<c:out value="${item.key } , ${item.value }"/><br>
	</c:forEach>
	
	<h1>fmt标签库</h1>
	<%
		Date date = new Date();
		pageContext.setAttribute("date", date);
		out.print(date);
	%><br>
	<fmt:formatDate value="${date }" pattern="yyyy-MM-dd HH:mm:ss" />
	
	<hr>
	<!-- 格式化数字 -->
	<%
		double d1 = 2.1;
		double d2 = 3.6;
		pageContext.setAttribute("d1", d1);
		pageContext.setAttribute("d2", d2);
	%><br>
	<fmt:formatNumber value="${d1 }" pattern="0.00"/><br>
	<!-- 必须且只能保留两位小数，如果大于两位小数，四舍五入后保留两位小数，如果小于两位，用0补足 -->
	<fmt:formatNumber value="${d2 }" pattern="#.##"/>
	<!-- 最多显示两位，如果小于两位，按实际显示，如果大于两位，只保留两位，四舍五入 -->
	
</body>
</html>