package com.hnuahe.soft02;

import java.util.Scanner;

public class J1016 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			double sum = 0;
			for(double i = 1; i <= n; i++) {
				if(i%2 == 0) {
					sum += -(1/i);
				}else {
					sum += 1/i;
				}
			}
			System.out.printf("%.5f", sum);
			System.out.println();
		}
		scanner.close();
	}

}
