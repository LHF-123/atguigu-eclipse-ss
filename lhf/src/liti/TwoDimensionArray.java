package liti;

import java.util.Random;
import java.util.Scanner;

public class TwoDimensionArray{
	public static void main(String[] args) {
		int[][] aa = {{1,2,3},{4,5,6},{7,8,9,10}}; // 里面几个大括号是几行，每一行上有几个数就是几列
//	二维数组是按行存储的。相当于定义了三个一维数组，分别是：aa[0],aa[1],aa[2]
		System.out.println(aa.length); // 数组aa中有几个一维
		System.out.println(aa[2].length);
//	如果定义的二维数组的列数不相同，只能逐个定义
		int[][] bb =  new int[3][];
		bb[0] = new int[3];
		bb[1] = new int [4];
		bb[2] = new int[5];
//	如果列都相等，通过下面的形式定义
		int m, n;
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); // m行
		n = sc.nextInt(); // n列
		int[][] cc = new int[m][n]; // 此种方式用的较多，前面数字表示行数，后面数字表示列数
		Random rd = new Random();
		int i, j;
		for(i = 0; i < m; i++) {
			for(j = 0; j < n; j++) { // 控制第i行上的所有列
				cc[i][j] = rd.nextInt(30) + 1;
				System.out.printf("%3d", cc[i][j]);
//	%3d，d是对应整型数据，3表示数据宽度，靠右对齐，左侧不够的补空格
			} // 此循环结束，表示第i行上的所有列处理完毕
			System.out.println();
		}
//	找出每一行上的最大值和最小值
		int max, min;
		for (i = 0; i < m; i++) {
			max = min = cc[i][0];
			for (j = 0; j < n; j++) {
				if(max < cc[i][j])
					max = cc[i][j];
				if(min > cc[i][j])
					min = cc[i][j];
			}
			System.out.println("第" + i + "行，最大值：" + max + "，最小值：" + min);
		}
//	找出每一列上的最大值和最小值
		for (j = 0; j < n; j++) {
			max = min = cc[0][j];
			for (i = 0; i < m; i++) {
				if (max < cc[i][j])
					max = cc[i][j];
				if (min > cc[i][j])
					min = cc[i][j];
			}
			System.out.println("第" + j + "列，最大值：" + max + "，最小值：" + min);
		}
		sc.close();
	}
}
