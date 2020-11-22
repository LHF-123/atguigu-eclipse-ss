package liti;

import java.util.Arrays;

public class ForUpper {
	public static void main(String[] args) {
//		定义一个数组，内容为：{10, 20, 30}，按以下形式输出：[10, 20, 30]
		int[] a = {10, 20, 30};
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if(i == a.length - 1)
				System.out.println(a[i] + "]");
			else
				System.out.print(a[i] + ", ");
		} // 每一步都是我们自己处理的
		System.out.println(Arrays.toString(a)); // 相当于面向对象的厨师

		for (int i : a) { // 增强的for循环
			System.out.print(i + " ");
		}
	}
}
