package com.hnuahe.soft02;

import java.util.Scanner;

public class yieryiqi {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			double sum = 0, sum1;
			n = scanner.nextInt();
			for(int i = 1; i <= n;i++) {
				sum1 = 0;
				sum1 += 1.0/i;
				sum += sum1;
			}
			System.out.printf("%.6f",sum);
		}
		scanner.close();
	}

}
