package com.atguigu.team.service;


import com.atguigu.team.bean.Architect;
import com.atguigu.team.bean.Designer;
import com.atguigu.team.bean.Employee;
import com.atguigu.team.bean.Programmer;
import com.atguigu.team.bean.Status;

public class TeamService {
	
	private static int counter = 1;//给memberId赋值使用
	private final static int MAX_MEMBER = 5;//限制开发团队的人数
	private static Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
	private static int total;//记录开发团队中实际人数
	
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	public void addMember(Employee e) throws TeamException {
		//成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
		//该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		//该员工已在本开发团队中
		if (isExit(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
		//该员工已是某团队成员
		//该员工正在休假，无法添加
		Programmer p = (Programmer) e;
		if ("BUSY".equalsIgnoreCase(p.getStatus().getName())) {//if (p.getStatus().name().equalsIgnoreCase("BUSY")) {有空指针异常的风险
			throw new TeamException("该员工已是某团队的成员");
		}else if ("VOCATION".equalsIgnoreCase(p.getStatus().getName())) {
			throw new TeamException("该员工正在休假，无法添加");
		}
		
		//团队中至多只能有一名架构师
		//团队中至多只能有二名设计师
		//团队中至多只能有三名程序员
		
		//获取team已有成员中架构师、设计师、程序员的人数
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			}else if (team[i] instanceof Designer) {
				numOfDes++;
			}else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		
		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("团队中至多只能有二名设计师");
			}
		}else if (p instanceof Programmer) {
			if (numOfPro >= 3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		
		//逻辑错误
		/*
		 * 	假设团队有两名设计师，添加一名架构师，p instanceof Architect为true，numOfArch >= 1为false
		 * 	返回false。考虑下面的p instanceof Designer，Architect的父类是Designer，为true
		 * 	numOfDes >= 2为true，整体返回true。
		 * 	会抛出TeamException("团队中至多只能有二名设计师")异常
		 */
//		if (p instanceof Architect && numOfArch >= 1) {
//			throw new TeamException("团队中至多只能有一名架构师");
//		}else if (p instanceof Designer && numOfDes >= 2) {
//			throw new TeamException("团队中至多只能有二名设计师");
//		}else if (p instanceof Programmer && numOfPro >= 3) {
//			throw new TeamException("团队中至多只能有三名程序员");
//		}
		//p的属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		//将p（或e）添加到现有的team中
		team[total++] = p;
		
		
	}
	
	//判断员工是否已在团队中
	private boolean isExit(Employee e) {
		
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i <total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FERR);
				break;
			}
		}
		
		//未找到指定memberId的情况
		if (i == total) {
			throw new TeamException("找不到指定的" + memberId + "的员工，删除失败");
		}
		
		//后一个元素覆盖前一个元素，实现删除操作
		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];
		}
		
		//写法一：
//		team[total - 1] = null;
//		total--;
		
		//写法二：
		team[--total] = null;
		
	}
	
}
