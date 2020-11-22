package com.newcapec.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_JDBC_01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2、获取连接：你们mysql数据库的版本是多少？
		//5.7版本以下,不需要?useUnicode=true&characterEncoding=utf8
		//我们连接的是practice,这个数据库里面有两个表,一个是emp员工表,一个是dept部门表
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=utf8", "root", "root");

		//3、创建执行SQL语句的Statement对象
		//statement 和 prepareStatement对象 ：都是用来执行SQL语句的
		//statement主要用来执行不带参数的简单SQL,会有SQL注入的风险,所以不推荐使用
		//statement在使用的时候,先创建Statement,然后再在executeXXX()传递SQL
		//Statement statement = connection.createStatement();
		//statement.executeQuery(sql); //Statement执行查询
		//statement.executeUpdate(sql);//Statement执行增删改
		
		//PreparedStatement预处理Statement,会预先处理SQL语句,并且参数会通过占位符的方式传递进来
		//在创建PreparedStatement的时候,就需要传递SQL
		//在我们写练习的时候，sql语句写*代表的是所有字段，没有什么问题；但是在公司开发中，绝对不要写*
		//查询所有员工的员工号、员工姓名、工种、工资、奖金、部门号
		String sql = "select empno,ename,job,sal,comm,deptno from emp";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		
		//4、执行sql语句
		ResultSet rs = prepareStatement.executeQuery(); //PreparedStatement执行查询
		
		//5、处理结果集
		while(rs.next()) {
			System.out.println(rs.getString("empno")+"\t"+rs.getString("ename"));
		}
		
		//6、释放资源：先打开的后关闭
		rs.close();
		prepareStatement.close();
		connection.close();
		
	}

}
