package com.newcapec.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.newcapec.dao.UserDao;
import com.newcapec.entity.User;
import com.newcapec.utils.MD5Util;

/*
 * 用来进行用户业务逻辑的处理
 */
public class UserService {
	private UserDao userDao = new UserDao();
	//判断用户名是否存在的业务逻辑 1表示存在了，0表示不存在
	public int userNameIsExist(String userName) {
		return userDao.userNameIsExist(userName);
	}
	
	//用户注册的业务逻辑
	public int userReg(User user) {
		//密码在存储到数据库之前,需要加密的，我们绝对不能把密码以明文方式存储在数据库里面
		//MD5Util就是用来进行加密的，而且是不可逆的
		String md5Pwd = MD5Util.toMD5(user.getUserPwd());
		user.setUserPwd(md5Pwd);
		return userDao.userReg(user);
	}
	
	//判断用户登录的业务逻辑
	public int userLogin(User loginUser) {
		//因为注册的时候已经密码加密,并且不可逆,所以我们登录的时候,也要用加密后的密码进行判定
		String md5Pwd = MD5Util.toMD5(loginUser.getUserPwd());
		loginUser.setUserPwd(md5Pwd);
		return userDao.userLogin(loginUser);
	}
	
	//查询所有用户的业务逻辑
	public List<User> queryAllUser(){
		//Dao反馈的数据
		List<Map<String, String>> listMap = userDao.queryAllUser();
		//我们希望反馈给Servlet的数据
		List<User> allUserList = new ArrayList<User>();
		
		//把listMap转换为allUserList
		for(Map<String, String> map:listMap) {
			User user = new User(Integer.valueOf(map.get("id")), map.get("userName"), map.get("userPwd"), map.get("realName"), map.get("sex"), map.get("hobby"));
			allUserList.add(user);
		}
		return allUserList;
	}
	
	//删除用户
	public int deleteUser(int deleteId) {
		return userDao.deleteUser(deleteId);
	}
	
	//根据id查询用户
	public User queryUserById(int updateId) {
		List<Map<String, String>> list = userDao.queryUserById(updateId);
		Map<String, String> map = list.get(0);
		User user = new User(Integer.valueOf(map.get("id")), map.get("userName"), map.get("userPwd"), map.get("realName"), map.get("sex"), map.get("hobby"));
		return user;
	}
	
	//修改用户
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
}
