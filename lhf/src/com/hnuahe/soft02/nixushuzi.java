package com.hnuahe.soft02;

import java.util.Scanner;

public class nixushuzi {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			while (n % 10 != 0) {
				System.out.print(n % 10 + " ");
				n = n / 10;
			}
		}
		scanner.close();
	
	}

}
