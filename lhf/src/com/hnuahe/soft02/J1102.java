package com.hnuahe.soft02;

import java.util.Scanner;

public class J1102 {

	public static void main(String[] args) {
		double a, b, c, d;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.nextDouble();
			b = scanner.nextDouble();
			c = scanner.nextDouble();
			d = scanner.nextDouble();
			System.out.printf("%.2f", Math.sqrt((b-d)*(b-d)+(a-c)*(a-c)));
			System.out.println();//Math.sqrt(a)¶Ôa¿ª¸ùºÅ
		}
		scanner.close();
	}

}
