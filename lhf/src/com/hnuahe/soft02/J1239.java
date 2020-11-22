package com.hnuahe.soft02;

import java.util.Scanner;

public class J1239 {

	public static void main(String[] args) {
		double a, b, c, d;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.nextDouble();
			b = scanner.nextDouble();
			c = scanner.nextDouble();
			d = scanner.nextDouble();
			System.out.println(String.format("%.2f", Math.sqrt((a - c) * (a - c) + (b -d) * (b -d))));
		}
		scanner.close();
	}

}
