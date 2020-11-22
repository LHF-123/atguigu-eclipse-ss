package com.hnuahe.soft02;

import java.util.Scanner;

public class yiyiersan {

	public static void main(String[] args) {
		int f;
		double c;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			f = scanner.nextInt();
			c=5*(f-32)/9;
			System.out.printf("c="+"%.2f",c);
		}
		scanner.close();
	}

}
