package com.hnuahe.soft02;

import java.util.Scanner;

public class shuixianhuashuwenti1 {

	public static void main(String[] args) {
		int a, b, c, i;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			i = scanner.nextInt();
			a = i / 100;
			b = i / 10 % 10;
			c = i % 10;
			if (a * a * a + b * b * b + c * c * c == i) {
				System.out.println("1");
			}else {
				System.out.println("0");
		}
		}
		scanner.close();
	}

}
