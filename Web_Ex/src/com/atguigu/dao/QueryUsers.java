package com.atguigu.dao;

import java.sql.Connection;
import java.util.List;

import com.atguigu.bean.User;
import com.atguigu.utils.JDBCUtils;

public class QueryUsers extends BasicDAO {
	private Connection  conn = JDBCUtils.getConnection();
	
	public User login(String uname, String upwd) {
		try {
			String sql = "SELECT * FROM ex_user WHERE uname = ? AND upwd = ?";
			return getById(User.class, sql, uname, upwd);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public List<User> queryAll() {
		try {
			String sql = "SELECT * FROM ex_user;";
			return getAll(conn, User.class, sql);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
