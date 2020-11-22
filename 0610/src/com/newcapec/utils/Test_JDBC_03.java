package com.newcapec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_JDBC_03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接：你们mysql数据库的版本是多少？
		//5.7版本以下,不需要?useUnicode=true&characterEncoding=utf8
		//我们连接的是practice,这个数据库里面有两个表,一个是emp员工表,一个是dept部门表
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=utf8", "root", "root");

		//3、创建执行SQL语句的Statement对象	
		//执行增删改操作 （更新操作）
		//新增一条数据
		String sql = "insert into emp(empno,ename,sal,comm,deptno)values(?,?,?,?,?)";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		//给占位符赋值
		prepareStatement.setInt(1, 1010); //给sql语句的第一个占位符设置值
		prepareStatement.setString(2, "张三");
		prepareStatement.setDouble(3, 4600.0);
		prepareStatement.setDouble(4, 500.0);
		prepareStatement.setInt(5, 10);
		
		//4、执行sql语句
		int i = prepareStatement.executeUpdate(); //PreparedStatement执行更新
		
		System.out.println(i);
		
		//6、释放资源：先打开的后关闭
		
		prepareStatement.close();
		connection.close();
		
	}

}
