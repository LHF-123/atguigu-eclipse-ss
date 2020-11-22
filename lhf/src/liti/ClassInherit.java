package liti;

public class ClassInherit {
	public static void main(String[] args) {
		Person person = new Person();
		//person.show();
		System.out.println("===================");
		person.setPerson("Jim", 18, "男"); // 字符串使用双引号；字符使用单引号
		//person.show();
		System.out.println("===================");
		Student student = new Student();
		student.show(); // 会输出继承到的姓名、年龄和性别么？？？
		System.out.println("===================");
		student.setPerson("Marry", 17, "女"); // 从Person类继承到的方法
		student.setName("Lili"); // 给新增的name赋值
//		在student对象中，有两个name，一个是继承的，一个是新增的
		student.setSchool("河南牧业经济学院");
		student.show(); // 调用子类自己的show()，因为名字相同把父类的show()覆盖了
		System.out.println("===================");
		Student stu = new Student("张三", 18, "男", "信息工程学院（软件学院）");
		stu.show();
		System.out.println("===================");
		PostgraduateStudent pstu = new PostgraduateStudent();
		pstu.show();
	}
}
class Person{
	private String name;
	private int age;
	private String sex;
	public Person() {
		System.out.println("Person类无参的构造方法");
	}
	public Person(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		System.out.println("Person类有参的构造方法");
	}
	public void setPerson(String name, int age, String sex) {
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
class Student extends Person{ // Student继承到了Person类的所有
	private String school;
	private String name; // 数据成员一般不覆盖
	public Student() {
		System.out.println("Student类无参的构造方法");
	}
	public Student(String name, int age, String sex, String school) {
		super(name, age, sex); // 调用Person类的构造方法，必须是第一条语句
		this.name = name;
		// 正确，给自己新增的name赋值
//		this.age = age; // 错误，直接给继承到的私有数据赋值，原因：not visible
		this.school = school;
		System.out.println("Student类有参的构造方法");
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void show() {
		super.show(); // 通过super调用父类的show()方法
		System.out.println("新增姓名：" + name);
		System.out.println("学校：" + school);
	}
}
class PostgraduateStudent extends Student{
	private float salary;
	public PostgraduateStudent() {
		System.out.println("PostgraduateStudent类的无参构造方法");
	}
	public void show() {
		super.show(); // 调用Student类的show()方法
		System.out.println("工资：" + salary);
	}
}
