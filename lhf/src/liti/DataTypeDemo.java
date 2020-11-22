package liti;

import java.util.Scanner;

/*
 * 基本数据类型：byte、short、int、long、float、double、char、boolean
 * Java是纯面向对象的语言，给基本的数据类型都定义了包装类：
 * byte --> Byte; short --> Short; int --> Integer; long --> Long
 * float --> Float; double --> Double; char --> Character; Boolean --> Boolean
 * */
public class DataTypeDemo {
	public static void main(String[] args) {
		String birth = "20011021";
		String year = birth.substring(0, 4);
		Scanner scanner = new Scanner(System.in);
		year = scanner.nextLine();
		int age = 0;
		try {
			age = 2019 - Integer.valueOf(year); // 转换year到整数时可能会产生异常
			System.out.println(age);
		} catch (NumberFormatException e) {
			System.out.println("输入的年份不正确！");
			return;
		}
		String sage = Integer.toString(age);
		System.out.println("整数年龄：" + (age + 1)); // 是连接运算还是加法运算
		System.out.println("字符串年龄：" + sage);
		scanner.close();
	}
}
