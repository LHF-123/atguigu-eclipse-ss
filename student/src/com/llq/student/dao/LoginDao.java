package com.llq.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private static final String URL="jdbc:mysql://localhost:3306/student";
	private static final String USERNAME = "root";
	private static final String PWD = "123456";
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pStatement;
	
	public int query(String uname,String upwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USERNAME,PWD);//获取连接对象，可能会抛出SQLException
			String sql = "SELECT * FROM user WHERE uname= ? and upwd = ? ";//?在此是占位符
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, uname);//1代表带一个问号，把uname赋给第一个?
			pStatement.setString(2, upwd);//2代表带二个问号，把upwd赋给第一个?
			rs = pStatement.executeQuery();
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
					if(pStatement != null)
					pStatement.close();//后出现的先关闭
					if(conn != null)
						conn.close();//先出现的后关闭
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return -1;
	}
}