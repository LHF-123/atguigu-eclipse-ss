package com.news.pojo;

import java.util.Date;

public class News {

	private int id;
	private String title;
	private int chnl_code;
	private String chnl_name;
	private String main_img;
	private String detail;
	private String optor;
	private Date crtime;
	private Date uptime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getChnl_code() {
		return chnl_code;
	}
	public void setChnl_code(int chnl_code) {
		this.chnl_code = chnl_code;
	}
	public String getChnl_name() {
		return chnl_name;
	}
	public void setChnl_name(String chnl_name) {
		this.chnl_name = chnl_name;
	}
	public String getMain_img() {
		return main_img;
	}
	public void setMain_img(String main_img) {
		this.main_img = main_img;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getOptor() {
		return optor;
	}
	public void setOptor(String optor) {
		this.optor = optor;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	
//	private String descr;
//	private String keyword;
//	private String source;
//	private int top;
//	private int state;
	
}
