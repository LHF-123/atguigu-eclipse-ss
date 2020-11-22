package com.hnuahe.soft02;

import java.util.Scanner;

public class C1021 {

	public static void main(String[] args) {
		double a, b;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			double sum = 0;
			a = scanner.nextDouble();
			b = scanner.nextDouble();
			sum = a * b;
			sum = sum / 2;
			System.out.printf("%.2f",sum);
		}
		scanner.close();
	}

}
