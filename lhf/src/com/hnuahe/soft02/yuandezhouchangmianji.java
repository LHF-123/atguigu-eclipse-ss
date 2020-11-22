package com.hnuahe.soft02;

import java.util.Scanner;

public class yuandezhouchangmianji {

	public static void main(String[] args) {
		int n;
		double pi = 3.14159;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		double C, S;
		while(n>0) {
			n--;
			double R = scanner.nextDouble();
			C =2 * pi * R;
			S =pi * R * R;
			System.out.printf("%.3f",C);
			System.out.println();
			System.out.printf("%.3f",S);
			System.out.println();
		}
		scanner.close();
	}

}
