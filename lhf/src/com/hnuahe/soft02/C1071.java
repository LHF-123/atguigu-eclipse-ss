package com.hnuahe.soft02;

import java.util.Scanner;

public class C1071 {

	public static void main(String[] args) {
		int a, b, n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		while(n > 0) {
			n--;
			a = scanner.nextInt();
			b = scanner.nextInt();
				System.out.println(a + b);
		}
		scanner.close();
	}

}
