package com.hnuahe.soft02;

import java.util.Scanner;

public class yiyier0 {

	public static void main(String[] args) {
		int a, b, c;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			if(a > b && a > c)
				System.out.println(a);
			if(b > a && b > c)
				System.out.println(b);
			if(c > b && c > a)
				System.out.println(c);
		}
		scanner.close();
	}

}
