package com.hnuahe.soft02;
public class BaseLoop {
	public static void main(String[] args) {
		// 求1+2+……+100的和
		int i = 1, sum = 0;
/*		while(i <= 100) {
			sum += i;
			i++; // 等价于：++i; i += 1;  i = i + 1;
			// 增加辅助输出，看看中间加的具体的值
			System.out.print(i + " ");
			if(i % 10 == 0) // 每输出10个数换一行
				System.out.println();
		}
		do {
			sum += i;
			i++;
		}while(i <= 100);*/
		// 在初始条件成立的情况下，两者完全一样（循环体、循环条件）
		// 当初始条件不成立，while一次也不执行，do...while执行一次
		
		/* for(表达式1; 表达式2; 表达式3){
		 * 	   循环体;
		 * }
		 * 表达式1：赋初值，只执行一次
		 * 表达式2：条件判断，条件成立，执行循环体；条件不成立，退出循环体
		 * 表达式3：循环控制变量的修改，让循环趋于终止
		 * 注意：三个表达式可以任意省略，但必须只能有两个分号
		 * */
		for(i = 1, sum = 0; i <= 100; i++) { // i += 2; 求1+3+……+99
			sum += i;
		}
/*		i = 1; sum = 0; // 相当于表达式1
		for(;;) {
			if(i > 100) // 相当于表达式2
				break; // 只能用在switch和循环中，在循环中，退出当前循环
			sum += i;
			i++; // 相当于表达式3
		}*/
		System.out.println("sum = " + sum);
		
		// 当循环次数已知时，建议使用for循环；循环次数未知时，建议使用while循环
		
		// 求1-2+3-...-100的和
		// 在上面一个循环执行结束后，i的值是：101，sum的值：5050
		// 此时再计算1-2+3-...-100的和时，能直接使用i和sum的值？？？
		i = 1; // 重新从1开始累加
		sum = 0; // 重新赋值为0
		int flag = 1;
		for(; i <= 100; i++) {
			sum += flag * i;
			flag = -flag;
		}
		System.out.println("sum = " + sum);
		
		// 求1+1/2+...+1/100的和
		// 前面定义的sum是int类型，不能存放小数
		double dsum = 0; // 用于小数求和
		for(i = 1; i <= 100; i++) { 
			dsum += 1.0 / i;
		}
		System.out.println("dsum = " + dsum);
		
		// 找出所有三位数中的水仙花数并输出：每个位上的数字的立方和等于该数
		int a, b, c;
		for(i = 100; i < 1000; i++) {
			a = i / 100; // 百位
			b = i / 10 % 10; // 十位 b = i % 100 / 10;
			c = i % 10; // 个位
			if (a * a * a + b * b * b + c * c * c == i) {
				System.out.println(i + "是水仙花数");
			}
		}
		 char ch = 'A';
	        for(i = 0; i < 26; i++) {
		         System.out.print((char)(ch + i));//所有字母大写
	}
	        for(i = 0; i < 26; i++) {
	        	System.out.print((char)(ch + i + 32));
	        }
	}
}
