package com.atguigu.bean;

public class Student {
	private String id;
	private String name;
	private String gender;
	private String age;
	private String address;
	
	public Student(String id, String name, String gender, String age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public Student() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", address=" + address
				+ "]";
	}
	
}
