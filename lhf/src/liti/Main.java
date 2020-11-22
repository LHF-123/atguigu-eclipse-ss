package liti;

public class Main {
	public static void main(String[] args) {
		Datea date1 = new Datea();
		date1.show();
		Datea date2 = new Datea(2019, 12, 25);
		date2.show();
//		date2.year = 2017; // 错误，不能直接访问私有数据
		date2.setDate(2017, 9, 23); // 成员方法，可以多次调用设定日期
		date2.show();
		date2.setMonth(12);
		date2.show();
		System.out.println(date2.getMonth() + "月");
	}
}
class Datea{
//	1. 第1种，通过给数据成员赋默认值的形式
	private int year = 2019, month = 11, day = 25;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	//	2. 第2种，通过语句块的形式赋值。先执行上面第1种的赋值，再执行该赋值。
	{
		year = 2018;
		month = 10;
		day = 24;
	}
	public Datea() {
		
	}
//	3. 第3种，通过构造方法形式，在第2种赋值后执行。
	public Datea(int y, int m, int d) {
		year = y;
		month =m;
		day = d;
	}
//	4. 第4种，通过公有方法访问
	public void setDate(int y, int m, int d) {
		year = y;
		month =m;
		day = d;
	}
//	5. 第5种，属性存取器，步骤：Source --> Generate Getters and Setters...
	public void setYear(int y) {
		year = y;
	}
	public void show() {
		System.out.println(year + "-" + month + "-" + day);
	}
}
