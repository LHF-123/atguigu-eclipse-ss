package com.hnuahe.soft02;

import java.util.Scanner;

public class yiyierwu {

	public static void main(String[] args) {
		int x;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
		x = scanner.nextInt();
		if(x < 1) {
			System.out.println(x);
		}
		if(x >= 1 && x < 10) {
			System.out.println(2*x-1);
		}
		if(x >= 10) {
			System.out.println(3*x-11);
		}
		}
		scanner.close();
	}

}
