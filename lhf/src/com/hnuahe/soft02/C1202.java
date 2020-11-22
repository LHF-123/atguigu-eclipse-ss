package com.hnuahe.soft02;

import java.util.Scanner;

public class C1202 {

	public static void main(String[] args) {
		int a, n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			int sum = 0, num = 0;
			a = scanner.nextInt();
			n = scanner.nextInt();
			for(int i = 1; i <=n; i++) {
				num = num * 10 + a;
				sum += num;
			}
			System.out.println(sum);
		}
		scanner.close();
	}

}
