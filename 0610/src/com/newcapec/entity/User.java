package com.newcapec.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userName;
	private String userPwd;
	private String realName;
	private String sex;
	private String hobby;
	public User() {
		
	}
	
	public User(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public User(Integer id, String userName, String userPwd, String realName, String sex, String hobby) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.realName = realName;
		this.sex = sex;
		this.hobby = hobby;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", realName=" + realName
				+ ", sex=" + sex + ", hobby=" + hobby + "]";
	}
	
	
}
