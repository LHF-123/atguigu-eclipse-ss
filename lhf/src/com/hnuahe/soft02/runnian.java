package com.hnuahe.soft02;

import java.util.Scanner;

public class runnian {

	public static void main(String[] args) {
		int a;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			a = scanner.nextInt();
			if(a % 400 == 0 || a % 4 == 0 && a % 100 != 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}

		scanner.close();
	}
}
