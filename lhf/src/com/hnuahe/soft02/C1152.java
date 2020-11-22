package com.hnuahe.soft02;

import java.util.Scanner;

public class C1152 {

	public static void main(String[] args) {
		int n, a, b, c, d;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			a = n/1000;
			b = n/100%10;
			c = n/10%10;
			d = n%10;
			System.out.println(a + " " + b + " " + c + " " +d);
		}
		scanner.close();
	}

}
