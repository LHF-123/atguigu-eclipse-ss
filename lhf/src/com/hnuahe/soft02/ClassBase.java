package com.hnuahe.soft02;

public class ClassBase {
	public static void main(String[] args) {
		Point pt = new Point(); // 系统自动调用无参的构造方法来构造对象pt
		pt.show();
		Point pt1 = new Point(3, 5); // 系统根据参数的个数或类型决定调用哪一个构造方法
		pt1.show();
//		pt.Point(3, 5); // 必须由系统调用
//		pt.x = 3;
//		pt.y = 5; // 私有的数据不能直接访问
//		Point pt2 = new Point(3); // 错误，没有定义一个参数的构造方法
	}
}
class Point{ // 定义一个类，名字叫：Point，不能加public
/* 构造方法：
 * 1. 名字必须与类名相同；
 * 2. 构造方法一般都是公有的；
 * 3. 构造方法不能有返回值类型；
 * 4. 系统默认提供一个无参方法体为空的构造方法，如果自定义的有，则系统不再提供；
 * 5. 在构造对象时，由系统自动调用一次，完成对象数据成员的初始化。
 */
	private int x, y; // 数据成员，也叫属性，一般为私有。类的数据成员都有默认值
	public Point() { // 系统默认的构造方法就长这样
		System.out.println("无参的构造方法");
	}
	public Point(int a, int b) {
		x = a;
		y = b;
		System.out.println("两个参数的构造方法");
	}
	public void show() { // 成员方法
		System.out.println("(" + x + "," + y + ")");
	}
}
