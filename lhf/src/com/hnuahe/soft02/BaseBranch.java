package com.hnuahe.soft02;

import java.util.Scanner;

public class BaseBranch {
	public static void main(String[] args) {
		System.out.println("Hello");
//		Soft02 soft02 = new Soft02(); // 创建对象
//		soft02.main(args);
		Scanner sc = new Scanner(System.in);
//		boolean b = true;
		
		int a=2147483647,b; // 变量必须先定义（声明），再使用；在使用前，必须有一个确定的值。
		b=a+2;
		System.out.println("a=" + a + ",b=" + b);
		System.out.println(Integer.SIZE/8);
		int c = (int)1.0; // 带小数点的默认是double类型
		// 强制转换：(强制转换到的类型)需要转换的数据或表达式
		float f = 2.0f;
		System.out.println(Float.SIZE/8);
		double d = f;
		int e = (int)d; // d是什么类型？d仍然是double类型
		System.out.println(Double.SIZE/8);
		char ch = 'A'; // 字符'A'的ASCII值是65
		System.out.println(ch + 1);
		System.out.println(Character.SIZE/8);
		char ch1 = (char)(ch + 32);
		System.out.println(ch1);
		
		int x=0x10,y=010, z=10;
		System.out.println("x=" + x + "\ty=" + y + "\nz=" + z);
		
		// 153 = 1^3 + 5^3 + 3^3
		// 找出百位：153 / 100 = 1
		// 找出十位：153 / 10 = 15, 15 % 10 = 5； 153 % 100 = 53, 53 / 10 = 5
		// 找出个位：153 % 10 = 3
		System.out.println(5/2); // 如果/两侧都是整数，表示整除，取商
		System.out.println(5/2.0); // 如果有一侧是小数，表示数学的除法
		System.out.println(5%2);
		
		// ++或--，如果是单独的一条语句，在前在后都一样；
		// 如果有赋值或判断（在if中），在前表示先运算再使用其值；在后表示先使用其值再运算。
		int i = 1, j;
		j = ++i;
		System.out.println("i=" + i + ",j=" + j);
		
		int k = i > j ? i : j; // 可以使用if语句进行等价转换
/*		if (i > j) {
			k = i;
		}else {
			k = j;
		}*/
		
		;;;;;;;;;;;;;;;;;;; // 空语句
		// 复合语句：大括号中的若干条语句在逻辑上相当于一条单语句。
		k = 1;
		if (--k == 0) {
			System.out.println("语句1");
			System.out.println("语句2");
		}
		
		// if一般形式：if(表达式) 语句; 当表达式成立时，执行语句。
		if (5 > 3) {
			System.out.println("5>3");
		}
		// if(表达式) 语句1; else 语句2; 表达式成立，执行语句1，否则执行语句2；
		if (x > 5) {
			x += 3;
		}else { // 表示的是什么？？？ x <= 5
			x -= 2;
		} // else不能单独出现，前面必须有与之配对的if语句
		// if...else 可以转换为两条if语句
		
		/*
		 * if(表达式1)
		 * 	   语句1;
		 * else if(表达式2）
		 * 	  语句2;
		 *   ...
		 * else // else可以没有
		 *   语句n;
		 * 说明：上面各条件及语句执行是互斥的。
		 * if...else if...else 可以转换为多条if语句
		 * */
		float score = 86.5f;
		if (score < 0 || score > 100) {
			System.out.println("输入的成绩无效！！！");
		}else {
/*			if (score >= 90) {
				System.out.println("优秀");
			}else if (score >= 80) {
				System.out.println("良好");
			}else if (score >= 70) {
				System.out.println("中等");
			}else if (score >= 60) {
				System.out.println("及格");
			}else { // 等价于：else if(score < 60)
				System.out.println("不及格");
			}*/
			// 将上面的if语句转换为switch实现
			switch ((int)score/10) {
			case 10: case 9:
				System.out.println("优秀");
				break;
			case 8:
				System.out.println("良好");
				break;
			case 7:
				System.out.println("中等");
				break;
			case 6:
				System.out.println("及格");
				break;
			default:
				System.out.println("不及格");
				break;
			}
		}
		
		// switch语句一般形式：
		// 执行流程：将表达式的值与case后面的值逐个进行相等比较，如果相等
		// 开始执行，直到遇到break或}结束；如果都不相等，则执行default，如果
		// 没有default，则什么也不执行。
		/* switch(表达式){ // 表达式要求：整型、字符型或String类型（JDK7以上）
		 *     case 表达式1：
		 *          语句1;
		 *          break;
		 *     case 表达式2:
		 *     		语句2;
		 *     		break;
		 *     ...
		 *     default:
		 *     		语句n;
		 *     		break;
		 *  }
		 * */
		int year=2016, month=2;
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31天");
			break;
		case 2:
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				System.out.println("29天");
			}else {
				System.out.println("28天");
			}
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30天");
			break;
		default:
			System.out.println("月份错误！！！");
			break;
		}
		
		int n = 50;
		double cost;
		if (n < 10) {
			cost = n*0.6;
		}else if (n >= 10 && n < 50) {
			cost = n*0.6*0.8;
		}else {
			cost = n*0.6*0.7;
		}
		System.out.println("费用：" + cost); 
		System.out.println(2.1 + 3.5); // +表示数学运算，运算的结果再转换为字符串输出
		System.out.println("2.1" + 3.5); // 先将3.5转换为字符串，+号在此表示字符串的连接
	}
}
