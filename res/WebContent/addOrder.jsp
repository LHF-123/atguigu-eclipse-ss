<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;"  background="image/bg.jpg">
	<form action="RestaurantServlet?action=addOrder" method="post">
		<font size="6" color="red">菜单</font><br><br>
		<font color="red">多选默认下单最下层选中的</font>
		<table align="center" border="1px">
			<tr bgcolor="yellow" align="center">
				<th>菜品名</th>
				<th>菜品图</th>
				<th>下单数量</th>
				<th>配送地址</th>
				<th>请选择其中一样菜品</th>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu1" value="北京烤鸭" readonly="readonly"/></td>
				<td><img alt="北京烤鸭" src="image/beiijngkaoya.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count1" value="1"/></td>
				<td><input type="text" name="address1"/></td>
				<td><input name="fid1" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu2" value="兰州拉面" readonly="readonly"/></td>
				<td><img alt="兰州拉面" src="image/lanzhoulamian.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count2" value="1"/></td>
				<td><input type="text" name="address2"/></td>
				<td><input name="fid2" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu3" value="串串香" readonly="readonly"/></td>
				<td><img alt="串串香" src="image/chuanchuanxiang.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count3" value="1"/></td>
				<td><input type="text" name="address3"/></td>
				<td><input name="fid3" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu4" value="热干面" readonly="readonly"/></td>
				<td><img alt="热干面" src="image/reganmian.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count4" value="1"/></td>
				<td><input type="text" name="address4"/></td>
				<td><input name="fid4" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu5" value="手抓羊肉" readonly="readonly"/></td>
				<td><img alt="手抓羊肉" src="image/shouzhuayangrou.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count5" value="1"/></td>
				<td><input type="text" name="address5"/></td>
				<td><input name="fid5" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu6" value="羊肉泡馍" readonly="readonly"/></td>
				<td><img alt="羊肉泡馍" src="image/yangroupaomo.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count6" value="1"/></td>
				<td><input type="text" name="address6"/></td>
				<td><input name="fid6" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu7" value="肉丸胡辣汤" readonly="readonly"/></td>
				<td><img alt="肉丸胡辣汤" src="image/hulatang.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count7" value="1"/></td>
				<td><input type="text" name="address7"/></td>
				<td><input name="fid7" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu8" value="盐焗鸡" readonly="readonly"/></td>
				<td><img alt="盐焗鸡" src="image/yanjuji.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count8" value="1"/></td>
				<td><input type="text" name="address8"/></td>
				<td><input name="fid8" type="radio"/></td>
			</tr>
			<tr bgcolor="lightblue">
				<td><input type="text" name="menu9" value="重庆酸辣粉" readonly="readonly"/></td>
				<td><img alt="重庆酸辣粉" src="image/suanlafen.jpg" height="60" width="100"/></td>
				<td><input type="text" name="count9" value="1"/></td>
				<td><input type="text" name="address9"/></td>
				<td><input name="fid9" type="radio"/></td>
			</tr>
		</table><br>
		<input type="submit" value="确认下单">
	</form>
</body>
</html>