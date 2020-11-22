package com.hnuahe.soft02;

import java.util.Scanner;

public class shuweifenli {

	public static void main(String[] args) {
		int n, a, b, c;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			a = n % 10;
			b = n / 10 % 10;
			c = n / 100;
			System.out.println(a + " " + b + " " + c);
		}
		scanner.close();
	}

}
