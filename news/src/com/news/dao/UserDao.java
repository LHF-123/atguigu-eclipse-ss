package com.news.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.news.util.DBUtils;
import com.news.pojo.User;
import com.news.util.DBUtil;

public class UserDao {

	public void insertUser(User user){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into sys_user(NAME,ACCT,PWD,CRTIME,UPTIME) values(?,?,?,now(),now())");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getAcct());
			stmt.setString(3, user.getPwd());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public void updateUser(User user){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update sys_user set NAME=?,ACCT=?,PWD=?,UPTIME=now() where ID=?");
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getAcct());
			stmt.setString(3, user.getPwd());
			stmt.setInt(4, user.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public void deleteUser(int id){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from sys_user where ID=?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, null);
	}
	
	public List<User> queryUser(){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			stmt = conn.prepareStatement("select ID,NAME,ACCT,PWD,CRTIME,UPTIME from sys_user");
			
			rs = stmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAcct(rs.getString(3));
				user.setPwd(rs.getString(4));
				user.setCrtime(rs.getTimestamp(5));
				user.setUptime(rs.getTimestamp(6));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return list;
	}
	
	public User login(String acct,String pwd){
		Connection conn = DBUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select ID,NAME,ACCT,PWD,CRTIME,UPTIME from sys_user where ACCT=? and PWD=?");
			stmt.setString(1, acct);
			stmt.setString(2, pwd);
			
			rs = stmt.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAcct(rs.getString(3));
				user.setPwd(rs.getString(4));
				user.setCrtime(rs.getTimestamp(5));
				user.setUptime(rs.getTimestamp(6));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn, stmt, rs);
		return null;
	}
	
	private DBUtils db = new DBUtils();
	//判断用户输入的用户名和密码是否存在于数据库
		/*public User userLogin(User loginUser) {
			String sql = "select ID,NAME,ACCT,PWD,CRTIME,UPTIME from sys_user where ACCT = ? and PWD = ?";
			Object obj[] = {loginUser.getAcct(),loginUser.getPwd()};
			List<Map<String, String>> list = db.query(sql, obj);
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setAcct(rs.getString(3));
			user.setPwd(rs.getString(4));
			user.setCrtime(rs.getTimestamp(5));
			user.setUptime(rs.getTimestamp(6));
			return list.size();
		}*/
}
