package com.news.service;

import com.news.dao.UserDao;
import com.news.pojo.User;
import com.news.util.MD5Util;

public class UserService {
	
	private UserDao userDao = new UserDao();
		//判断用户登录的业务逻辑
		public User userLogin(String acct,String pwd) {
			//因为注册的时候已经密码加密,并且不可逆,所以我们登录的时候,也要用加密后的密码进行判定
			String md5Pwd = MD5Util.toMD5(pwd);
			return userDao.login(acct, md5Pwd);
		}
	
}
