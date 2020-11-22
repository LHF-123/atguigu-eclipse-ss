package com.atguigu.team.bean;

public class Programmer extends Employee {
	
	private int memberId;
	private Status status = Status.FERR;
	private Equipment equipment;
	
	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		/*
		 * ID     姓名      年龄    工资           职位      状态      奖金         股票    领用设备
 			1      段誉     	 22   3000.0
 			2      令狐冲    	 32   18000.0   架构师   FREE  15000.0  2000    联想T4(6000.0)
 			3      任我行  	 23   7000.0     程序员   FREE                 戴尔(NEC17寸)
 			4      张三丰  	 24   7300.0     程序员   FREE                 戴尔(三星 17寸)
 			5      周芷若  	 28   10000.0   设计师   FREE   5000.0                佳能 2900(激光)

		 */
		return getEmployeeBasicInfo() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String getTeamBaseDetails() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}
	
	//2/6	任志强	22	6800.0	程序员
	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t程序员";
	}

}
