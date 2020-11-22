package com.hnuahe.soft02;

import java.util.Scanner;

public class ABProblem {

	public static void main(String[] args) {
		int a, b;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			System.out.println(a + b);
		}
		scanner.close();
	}

}
