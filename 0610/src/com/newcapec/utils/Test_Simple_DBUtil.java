package com.newcapec.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * 测试使用轻量级DBUtil
 */
public class Test_Simple_DBUtil {
	public static void main(String[] args) throws SQLException {
		//1.获取连接：通过DBUtil工具类得到数据库连接对象
		Connection conn = DBUtil_Simple.getConnection();
		
		//2.创建执行sql的prepareStatement
		String sql = "select * from emp where deptno = ? and sal > ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, 10);
		ps.setDouble(2, 3500.0);
		
		//3.执行sql
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("empno")+"\t"+rs.getString("ename"));
		}
		
		//4.关闭资源
		DBUtil_Simple.close(conn, ps, rs);
		
	}
}
