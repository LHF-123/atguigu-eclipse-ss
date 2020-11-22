// 双斜线表示单行注释（说明性的文档），不参与编译
// package 包的路径
package com.hnuahe.soft02;
/* 多行注释，所有放在中间的文字都是注释；
 * public 访问修饰符，公有的；
 * 四种访问权限：public、默认、protected、private；
 * class 定义一个类，名字叫HelloWorld；
 * 类前有public的类称为主类，要求与文件名同名。 
 * */
public class HelloWorld {
	/* static 静态的；
	 * void 表示main的返回值类型是void；
	 * main 程序的入口，即从此开始执行，有且只有一个；
	 * String 字符串类；
	 * () 在此是方法的标记；还可以表示运算符；
	 * [] 在此是定义数组；也是下标运算符；
	 * {} 在此表示方法体；还可以是语句块；
	 * 注意：双引号、单引号、三种括号都要求成对出现；
	 * args 参数的名字
	 * */
	public static void main(String[] args) {
	    // 调用System类的out对象中的println()方法输出
		// 输出位置：Console控制台
		System.out.println("Java, 我爱你！");
	}
}
