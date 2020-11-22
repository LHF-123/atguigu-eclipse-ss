package com.lhf.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lhf.restaurant.util.DBUtil;

public class LoginDao {
	private static Connection conn = null;
	private static ResultSet rs = null;
	private static PreparedStatement pStatement;
	
	public int query(String username,String upwd) {
		try {
			conn = DBUtil.getConnection();//通过DBUtil访问数据库
			String sql = "SELECT * FROM user WHERE username= ? and upwd = ? ";
			pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, username);//1代表带一个问号，把uid赋给第一个?
			pStatement.setString(2, upwd);//2代表带二个问号，把upwd赋给第一个?
			rs = pStatement.executeQuery();
			int count = 0;//假设没有找到
			while(rs.next()) {//正常情况下用户名和密码是唯一的
				count = rs.getInt(1);
			}
			return count;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return -1;
	}
}
