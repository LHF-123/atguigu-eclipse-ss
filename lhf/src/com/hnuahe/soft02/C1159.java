package com.hnuahe.soft02;

import java.util.Scanner;

public class C1159 {

	public static void main(String[] args) {
		double a, b, c;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			if(a > b) {
				double t = a;
				a = b;
				b = t;
			}
			if(a > c) {
				double t = a;
				a = c;
				c = t;
			}
			if(b > c) {
				double t = b;
				b = c;
				c = t;
			}
			System.out.println(String.format("%.3f", c));
			System.out.println(String.format("%.3f", c));
		}
		scanner.close();
	}

}
