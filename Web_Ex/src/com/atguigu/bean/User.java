package com.atguigu.bean;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements Serializable, HttpSessionBindingListener{
	private Integer id;
	private String uname;
	private String upwd;
	
	public User(Integer id, String uname, String upwd) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
	}
	
	

	public User(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}



	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upwd=" + upwd + "]";
	}

	//向session域中添加User对象时调用的
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		//获取session对象
		HttpSession session= event.getSession();
		//获取ServletContext对象
		ServletContext  application = session.getServletContext();
		//从application域中获取当前在线人数
		Integer count = (Integer) application.getAttribute("count");
		if (count == null) {
			//证明之前还没有人上线，我是第一人，此时要向application域中设置在线人数为1
			application.setAttribute("count", 1);
		}else {
			//证明之前已经有人在线，此时需要将之前的在线人数加1，并再次放到application域中
			application.setAttribute("count", count + 1);
		}
	}

	//向session域中移除User对象时调用的
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		//获取session对象
		HttpSession session= event.getSession();
		//获取ServletContext对象
		ServletContext  application = session.getServletContext();
		Integer count = (Integer) application.getAttribute("count");
		application.setAttribute("count", count - 1);
	}
	
}
