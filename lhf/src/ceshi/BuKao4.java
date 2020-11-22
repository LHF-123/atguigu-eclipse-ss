package ceshi;

public class BuKao4 {

	public static void main(String[] args) {
		Student student = new Student("19171202021", "王鑫", 20, 'm', "17716352766");
		student.showInfo();
	}
	
}
class Person {
	private String name;
	private int age;
	private char sex;
	
	public Person(String name, int age, char sex) {
		super();
		if (sex == 'm') {
			sex = '男';
		}else if (sex == 'f') {
			sex = '女';
		}
		this.name = name;
		this.age = age;
		this.sex = sex;
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void showInfo() {
		System.out.println("姓名：" + name + "，年龄：" + age + "，性别：" + sex);
	}
}
class Student extends Person{
	private String id;
	private String phone;
	
	public Student(String id, String name, int age, char sex, String phone) {
		super(name, age, sex);
		this.id = id;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public void showInfo() {
		System.out.println("学号：" + id + "，姓名：" + getName() + "，年龄：" + getAge() 
		+ "，性别：" + getSex() + "，联系电话：" + phone) ;
	}
	
	
}