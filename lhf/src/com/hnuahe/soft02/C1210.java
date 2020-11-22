package com.hnuahe.soft02;

import java.util.Scanner;

public class C1210 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			for(int i = 2; i<= n; i++) {
				if(n % i == 0 && n != i) {
					System.out.println("0");
					break;
				}if(i == n) {
					System.out.println("1");
				}
			}
		}
		scanner.close();
	}

}
