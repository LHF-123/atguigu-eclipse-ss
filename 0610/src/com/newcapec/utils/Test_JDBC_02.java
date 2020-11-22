package com.newcapec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_JDBC_02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接：你们mysql数据库的版本是多少？
		//5.7版本以下,不需要?useUnicode=true&characterEncoding=utf8
		//我们连接的是practice,这个数据库里面有两个表,一个是emp员工表,一个是dept部门表
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=utf8", "root", "root");

		//3、创建执行SQL语句的Statement对象	
		//PreparedStatement预处理Statement,会预先处理SQL语句,并且参数会通过占位符的方式传递进来
		//在创建PreparedStatement的时候,就需要传递SQL
		//如果使用的是Statement对象,我们进行的是SQL拼接，那么PreparedStatement,使用占位符,在prepareStatement执行的sql里面，?就是占位符
		
		////查询指定部门员工的信息
		//我们通过一个变量来存储要查询的部门号
		int deptno = 10;
		double sal = 3500.0;
		//String sql = "select empno,ename,job,sal,comm,deptno from emp where deptno = ?";
		
		//查询指定部门的员工,并且工资大于3500
		String sql = "select empno,ename,job,sal,comm,deptno from emp where deptno = ? and sal > ?";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		//给占位符赋值
		prepareStatement.setInt(1, deptno); //给sql语句的第一个占位符设置值
		prepareStatement.setDouble(2, sal);
		
		//4、执行sql语句
		ResultSet rs = prepareStatement.executeQuery(); //PreparedStatement执行查询
		
		//5、处理结果集
		while(rs.next()) {
			System.out.println(rs.getString("empno")+"\t"+rs.getString("ename")+"\t"+rs.getString("sal")+"\t"+rs.getString("deptno"));
		}
		
		//6、释放资源：先打开的后关闭
		rs.close();
		prepareStatement.close();
		connection.close();
		
	}

}
