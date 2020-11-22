package liti;

import java.util.Random;
import java.util.Scanner;

public class StringArray {
	public static void main(String[] args) {
		char[] chs = new char[62]; // 存储所有字母和数字字符 
		int i;
		for(i = 0; i < 26; i++) {
			chs[i] = (char) ('A' + i); // 存放大写
			chs[i + 26] = (char) ('a' + i); // 存放小写
			if(i < 10) // 数字字符只有10个
				chs[i + 52] = (char) ('0' + i);
		}
		System.out.println(chs);
//	Random类，随机数产生器类，Random rd = new Random();
//	思路：随机产生一个下标，将里面的字符拿出来组合
//	产生随机数的下标范围：[0,61]，rd.nextInt(62);
		int n, index;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Random rd = new Random(); // 使用系统时间做种子
		for(i = 0; i < n; i++) {
			index = rd.nextInt(62); // 限定下标不越界
			System.out.print(chs[index]);
		}
		System.out.println();
//	将2班所有同学的学号存储，使用String类
		String[] nums = new String[50];
		for(i = 0; i < 50; i++) {
			if(i < 9)
				nums[i] = "1917120200" + (i + 1);
			else
				nums[i] = "191712020" + (i + 1);
//			System.out.println(nums[i]);
		}
		System.out.println(nums[rd.nextInt(50)]);
//	随机分组，10人一组
		n = 100;
		int index1, index2;
		for(i = 0; i < n; i++) {
			index1 = rd.nextInt(50);
			index2 = rd.nextInt(50);
			String t = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = t;
		}
//	输出分组后的结果
		for(i = 0; i < 50; i++) {
			System.out.print(nums[i] + " ");
			if((i + 1) % 10 == 0)
				System.out.println();
		}
//	如何给字符串赋值？？？
//	两种方法：
//		1.next(); 读取的字符串不能包含空格、tab键或回车
//		2.nextLine(); 可以包含空格和字符串，遇到回车结束
		String str = "Hello world.";
		System.out.println(str);
		
//		str = sc.next(); // 通过键盘赋值
		sc.nextLine(); // 接收上一个回车
		str = sc.nextLine();
		System.out.println(str);
//	输入一个字母，小写转大写，大写转小写
//	无法控制输入字符串的长度！！！，只能取一个
		String strCh = sc.nextLine();
//		char ch = strCh.toCharArray()[0];
/*		char[] ch1 = strCh.toCharArray();
		char ch = ch1[0];*/
		char ch = strCh.charAt(0);
 		sc.close();
	}
}
