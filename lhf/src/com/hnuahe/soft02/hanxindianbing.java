package com.hnuahe.soft02;

import java.util.Scanner;

public class hanxindianbing {

	public static void main(String[] args) {
		int n, a, b, c;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			for(n =10; n <=100; n++) {
				if(n % 3 == a && n % 5 == b && n % 7 == c) {
					System.out.println(n);
					break;
				}
			}
			if(n < 10 || n > 100) {
				System.out.println("No answer");
			}
			}
		scanner.close();
	}
}
