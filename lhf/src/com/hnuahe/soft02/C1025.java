package com.hnuahe.soft02;

import java.util.Scanner;

public class C1025 {

	public static void main(String[] args) {
		int m, n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int sum = 0;
			m = scanner.nextInt();
			n = scanner.nextInt();
			sum = m * n * 1500;
			System.out.println(sum);
		}
		scanner.close();
	}

}
