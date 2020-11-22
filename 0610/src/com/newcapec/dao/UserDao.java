package com.newcapec.dao;

import java.util.List;
import java.util.Map;

import com.newcapec.entity.User;
import com.newcapec.utils.DBUtils;
import com.newcapec.utils.MD5Util;

/*
 * 用户持久层
 */
public class UserDao {
	private DBUtils db = new DBUtils();
	//判断用户名是否存在数据库
	public int userNameIsExist(String userName) {
		String sql = "select * from user where userName = ?";
		Object obj[] = {userName};
		List<Map<String, String>> list = db.query(sql, obj);
		return list.size();
	}
	
	//用来把用户数据存储到数据库中
	public int userReg(User user) {
		String sql = "insert into user(userName,userPwd,realName,sex,hobby) values(?,?,?,?,?)";
		Object obj[] = {user.getUserName(),user.getUserPwd(),user.getRealName(),user.getSex(),user.getHobby()};
		return db.update(sql, obj);
	}
	
	//判断用户输入的用户名和密码是否存在于数据库
	public int userLogin(User loginUser) {
		String sql = "select * from user where userName = ? and userPwd = ?";
		Object obj[] = {loginUser.getUserName(),loginUser.getUserPwd()};
		List<Map<String, String>> list = db.query(sql, obj);
		return list.size();
	}
	
	//查询所有用户
	public List<Map<String, String>> queryAllUser(){
		String sql = "select * from user";
		Object obj[] = {};
		return db.query(sql, obj);
	}
	
	public int deleteUser(int deleteId) {
		String sql = "delete from user where id = ?";
		Object obj[] = {deleteId};
		return db.update(sql, obj);
	}
	
	public List<Map<String, String>> queryUserById(int updateId) {
		String sql = "select * from user where id = ?";
		Object obj[] = {updateId};
		return db.query(sql, obj);
	}
	
	public int updateUser(User user) {
		String sql = "update user set realName = ?,sex=? where id = ?";
		Object obj[] = {user.getRealName(),user.getSex(),user.getId()};
		return db.update(sql, obj);
	}
}
