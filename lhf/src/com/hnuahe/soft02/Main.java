package com.hnuahe.soft02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextLine();
		if("19171206001".equals(n)) {
			Student student = new Student("Marry", 18, "女","19171205001","河南牧业经济学院");
			student.show();
		}
		scanner.close();
	}

}
class Person{
	private String name;
	private int age;
	private String sex;
	public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public void show() {
		System.out.println("姓名：" + name);
		System.out.println("年龄：" + age);
		System.out.println("性别：" + sex);
	}
}
class Student extends Person{
	private String id;
	private String school;
	public Student(String name, int age, String sex,String id, String school) {
		super(name, age,sex);
		this.id = id;
		this.school = school;
	}
	public void show() {
		String n;
		n = "6班";
		super.show();
		System.out.println("学号：" + id);
		System.out.println("学校：" + school);
		System.out.println("班级：" + n);
	}
}