package com.atguigu.team.bean;

/*
 * FERR-空闲
 * BUSY-已加入开发团队
 * VOCATION-正在休假
 */
public enum Status {
	FERR("FREE"),BUSY("BUSY"),VOCATION("VOCATION");
	private final String NAME;

	private Status(String nAME) {
		NAME = nAME;
	}

	public String getName() {
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}
	
	
	
	
}
