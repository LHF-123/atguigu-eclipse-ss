package com.hnuahe.soft02;

import java.util.Scanner;

public class dazheyouhui {

	public static void main(String[] args) {
		double n, sum;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
		n = scanner.nextInt();
		if(n < 10) {
			sum = 0.6 * n;
			System.out.println(String.format("%.2f",sum));
		}
		else if(n >= 10 && n < 50) {
			sum = 0.6 * 0.8 * n;
			System.out.println(String.format("%.2f",sum));
		}
		else if(n >= 50) {
			sum = 0.6 * 0.7 * n;
			System.out.println(String.format("%.2f",sum));
		}
		}
		scanner.close();
	}

}
