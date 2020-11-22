package com.atguigu.team.bean;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private double salary;
	
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		/*
		 * ID     姓名      年龄    工资      职位      状态      奖金      股票    领用设备
 		   1   	   段誉       22   3000.0

		 */
		return getEmployeeBasicInfo();
	}

	protected String getEmployeeBasicInfo() {
		return id + "\t" + name + "\t" + age + "\t" + salary;
	}

}
