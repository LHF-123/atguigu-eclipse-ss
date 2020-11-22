package com.hnuahe.soft02;

import java.util.Scanner;

public class J1106 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			int sum = 1;
			for(int i = 0; i < n; i++) {
			int k = scanner.nextInt();
			if(k % 2 != 0) {
				sum *= k;
			}
			}
			System.out.println(sum);
		}
		scanner.close();
	}

}
