package com.hnuahe.soft02;

import java.util.Scanner;

public class C1027 {

	public static void main(String[] args) {
		int n, m;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			double sum1 = 0, sum2 = 0;
			n = scanner.nextInt();
			m = scanner.nextInt();
			if(m < 6) {
				System.out.println("0.00L");
			}else {
			sum1 = n * 550;
			sum2 = ((m - 5)*sum1)/1000;
			System.out.printf("%.2fL", sum2);
			System.out.println();
			}
		}
		scanner.close();
	}

}
