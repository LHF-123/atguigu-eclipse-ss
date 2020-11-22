package com.hnuahe.soft02;

import java.util.Scanner;

public class J1240 {

	public static void main(String[] args) {
		double n, sum;
		double pi;
		pi = (double) 3.1415927;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextDouble();
			sum = 4/3d * pi*n*n*n;
			System.out.printf("%.3f",sum);
			System.out.println();
		}
		scanner.close();
	}

}
