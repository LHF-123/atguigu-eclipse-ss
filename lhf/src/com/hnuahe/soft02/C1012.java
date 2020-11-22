package com.hnuahe.soft02;

import java.util.Scanner;

public class C1012 {

	public static void main(String[] args) {
		int a, b, c, i;
		Scanner scanner = new Scanner(System.in);
		i = scanner.nextInt();
		while(i>0) {
			i--;
			int sum = 0;
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			sum = a * b * c;
			System.out.println(sum);
		}
		scanner.close();
	}

}
