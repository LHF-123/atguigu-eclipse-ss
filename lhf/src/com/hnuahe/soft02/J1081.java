package com.hnuahe.soft02;

import java.util.Scanner;

public class J1081 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		while(scanner.hasNext()) {
			String str = scanner.next();
			String number = str.substring(8,11);
			System.out.println("8" + number);
		}
		scanner.close();
	}

}
