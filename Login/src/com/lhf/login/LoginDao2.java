package com.lhf.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao2 {
	private static final String URL="jdbc:mysql://localhost:3306/jdbc";
	private static final String USERNAME = "root";
	private static final String PWD = "123456";
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public int query(String uname,String upwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USERNAME,PWD);//获取连接对象，可能会抛出SQLException
			stmt = conn.createStatement();
			String sql = "SELECT * FROM user WHERE uname='"+uname+"'and upwd ='"+upwd+"'";
			rs = stmt.executeQuery(sql);
			int count = 0;//假设没有找到
			while(rs.next()) {//正常情况下用户名和密码是唯一的
				count = rs.getInt(1);
				}
			return count;
			}
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
					stmt.close();//后出现的先关闭
					if(conn != null)
						conn.close();//先出现的后关闭
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return -1;
	}
}
