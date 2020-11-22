package liti;

import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		int a[]; // 声明一个数组，数组名叫a，C/C++/C#/Java都能用
		int []b; // 声明一个数组，数组名叫b，Java专用，建议使用
		int[] c; //[]的位置，更建议此种格式
// 数组：一组相同数据类型元素的集合，存储空间是连贯的。容量和定义的大小有关
		a = new int[10]; // 数组a能存放10个整型（int）类型的元素
		b = new int[100]; // 容量是100
// a[i]，i叫下标，数组下标从0开始，到a.length - 1结束，不能越界！！！
// 所有的数组都有一个属性值：length，存的是数组的长度
// 在通过new初始化时，自动赋初值，不同的类型初始值不相同
		System.out.println(a.length);
		System.out.println(b.length);
//		System.out.println(c.length); // 错误，在使用数组c前，要初始化
		int i, j;
		for(i = 0; i < a.length; i++) {
			a[i] = i + 1; // 将1~10赋值
			System.out.print(a[i] + " ");
		}
		System.out.println();
		int[] d = {1,2,3,4,5,6,7,8,9,10,11,12};
// 根据初始值的数量计算出数组的大小
//		c = {1,2,3,4,5,6}; // 错误，这种赋值方式只能在声明数组时使用
		System.out.println(d.length);
		
//	输入10个整数，输出最小、最大的数及其下标
		System.out.println("输入10个整数，求最大值、最小值及其下标：");
		Scanner sc = new Scanner(System.in);
		for(i = 0; i < a.length; i++) {
			a[i] = sc.nextInt(); // a[0], a[1]....
		} // 实现对数组的赋值
		int max = a[0], maxIndex = 0; // 假设最前面一个最大
		int min = a[0], minIndex = 0; // 假设最前面一个最小
		for(i = 0; i < a.length; i++) {
			if(max < a[i]) {
				max = a[i]; // 找到了更大的，替换原来的值
				maxIndex = i; // 更新最大值所在的位置：下标
			}
			if(min > a[i]) {
				min = a[i];
				minIndex = i;
			}
		} // 循环：找出最大值和最小值
		System.out.println("最大值：" + max + "，下标：" + maxIndex);
		System.out.println("最小值：" + min + "，下标：" + minIndex);

// 评委打分：有10个评委打分，去掉一个最高分，去掉一个最低分，得分：平均值
		float[] scores = new float[10];
		System.out.println("请输入十个评委的打分：");
		for(i = 0; i < scores.length; i++) {
			scores[i] = sc.nextFloat();
		}
		float fmax, fmin, fsum;
		fmax = fmin = 0;
		fsum = 0;
		for(i = 0; i < scores.length; i++) {
			if(fmax < scores[i])
				fmax = scores[i];
			if(fmin > scores[i])
				fmin = scores[i];
			fsum += scores[i]; // 累加了所有班委的分数
		}
		System.out.println((fsum - fmax - fmin) / (scores.length - 2));
		
//	输入10个整数，按从小到大的顺序输出
/* 冒泡法：相信的两个数相比，小的数上浮，大的数下沉
 * 原始数据：4 2 6 5 1 3
 * 第  0　轮：2 4 5 1 3 6 此轮比较结束后，最大值6已经沉底
 * 第  1　轮：2 4 1 3 5
 * 第  2　轮：2 1 3 4
 * 第  3　轮：1 2 3
 * 第  4　轮：1 2
 * 用n表示数据的个数，比较了多少轮？n-1轮
 * i控制轮数，初始条件：i=0; 循环条件：i<n-1
 * j控制每一轮上比较的次数，初始条件：j=0; 循环条件：j<n-i-1
 */
//	直接使用上次a数组中的值
		for(i = 0; i < a.length - 1; i++) { // 控制比较的轮数
			for(j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j+1]) { // 下标运算后确保不能越界
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
				}
			}
			System.out.print("第" + i + "轮："); // 辅助输出，查看每一轮比较的结果
			for(int k = 0; k < a.length - i; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println(); // 每一轮结束后输出一个换行
		}
		for(i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		} // 输出最终排序后的结果
		System.out.println();
// 选择法排序：每次选择一个合适的数放在合适的位置
/* 思路：第0轮，找一个最小的和0下标位置交换；第1轮找一个次小的和1下标对应位置交换……
 * 原始数据：4 2 6 5 1 3
 * 第  0　轮：1 2 6 5 4 3
 * 第  1　轮：    2 6 5 4 3
 * 第  2　轮：        3 5 4 6 
 * 第  3　轮：            4 5 6
 * 第  4　轮：                5 6
 * 轮数：n-1轮，i控制轮数，与冒泡法一样
 * 每一轮上比较的次数：初始值j=i; 循环条件：j<n
 * 在每一轮比较结束后，怎么知道当前要找的数所在的位置？？？
 * 定义一个下标变量：index，每轮比较结束后，a[index] <--> a[i]交换
 * 在每一轮比较之前，将index=i; 如果有比index对应的值还小的，将下标替换
*/
		sc.close();
	}
}
