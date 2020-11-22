package com.hnuahe.soft02;

import java.util.Scanner;

public class J1127 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			if(n < 10) {
				System.out.println("1");
				System.out.println(n);
			}
			if(n < 100 && n >= 10) {
				System.out.println("2");
				System.out.print(n / 10 + " ");
				System.out.println(n % 10);
			}
			if(n < 1000 && n >= 100) {
				System.out.println("3");
				System.out.print(n / 100 + " ");
				System.out.print(n / 10 % 10 + " ");
				System.out.println(n % 10);
			}
			if(n < 10000 && n >= 1000) {
				System.out.println("4");
				System.out.print(n / 1000 + " ");
				System.out.print(n / 100 % 10 + " ");
				System.out.print(n / 10 % 10 + " ");
				System.out.println(n % 10);
			}
			if(n < 100000 && n >= 10000) {
				System.out.println("5");
				System.out.print(n / 10000 + " ");
				System.out.print(n / 1000 % 10 + " ");
				System.out.print(n / 100 % 10 + " ");
				System.out.print(n / 10 % 10 + " ");
				System.out.println(n % 10);
			}
			while (n % 10 != 0) {
				System.out.print(n % 10);
				n = n / 10;
			}
		}
		scanner.close();
	}

}
