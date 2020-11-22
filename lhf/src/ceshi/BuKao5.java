package ceshi;

public class BuKao5 {

	public static void main(String[] args) {
		Cat cat1 = new Cat();
		Cat cat2 = new Cat("兰兰", 8, 2);
		cat1.setName("花花");
		cat1.setWeight(10);
		cat1.setAge(3);	
		
		System.out.println(cat1);
		System.out.println(cat2);
		
		cat1.climbTree("花花", 2);
		cat2.climbTree("兰兰", 4);
	}

}
class Cat {
	private String name;
	private int weight;
	private int age;
	private static String hobby = "睡觉";
	
	public Cat() {
		super();
	}

	public Cat(String name, int weight, int age) {
		super();
		this.name = name;
		this.weight = weight;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static String getHobby() {
		return hobby;
	}

	public static void setHobby(String hobby) {
		Cat.hobby = hobby;
	}

	public void climbTree(String name, int height) {
		System.out.println(name + "会爬树" + "，能爬" + height + "米");
	}

	@Override
	public String toString() {
		return "姓名：" + name + ", 体重：" + weight + ", 年龄：" + age + ", 爱好：" + hobby;
	}
	
	
}
