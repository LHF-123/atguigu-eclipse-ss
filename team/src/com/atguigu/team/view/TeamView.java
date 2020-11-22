package com.atguigu.team.view;

import org.junit.Test;

import com.atguigu.team.bean.Employee;
import com.atguigu.team.bean.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;
import com.atguigu.team.utils.TSUtility;

public class TeamView {
	
	@Test
	public void menu() {
		boolean loopFlag = true;
		
		while (loopFlag) {
			System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			getAllEmployee();
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： ");
			
			char menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				listTeamMember();
				break;
			case '2':
				addTeamMember();
				break;
			case '3':
				removeTeamMember();
				break;
			case '4':
				System.out.println("是否确认退出(Y/N)：");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
				break;
			}
			
		}
		
	}

	private void getAllEmployee() {
		NameListService ns = new NameListService();
		Employee[] all = ns.getAll();
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		
	}

	private void addTeamMember() {
		System.out.println("-------------------------------------添加成员--------------------------------------\n");
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		
		NameListService ns = new NameListService();
		TeamService ts = new TeamService();
		
		try {
			Employee emp = ns.getById(id);
			ts.addMember(emp);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		
		//按回车键继续...
		TSUtility.readReturn();
		
	}
	
	private void removeTeamMember() {
		System.out.println("-------------------------------------删除成员--------------------------------------\n");
		System.out.print("请输入要删除员工的TID：");
		int memberId = TSUtility.readInt();
		
		System.out.println("确认是否删除(Y/N)：");
		char isDelete = TSUtility.readConfirmSelection();
		if (isDelete == 'N') {
			return;
		}
		
		TeamService ts = new TeamService();
		
		try {
			ts.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		
		//按回车键继续...
		TSUtility.readReturn();
		
	}
	
	private void listTeamMember() {
		System.out.println("--------------------团队成员列表---------------------\n");
		
		TeamService ts = new TeamService();
		
		Programmer[] team = ts.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("开发团队目前没有成员");
			System.out.println("---------------------------------------------------");
		}else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
			System.out.println("---------------------------------------------------");
		}
		
	}
	
}
