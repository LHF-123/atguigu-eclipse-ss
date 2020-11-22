package com.hnuahe.soft02;

import java.util.Scanner;

public class J1144 {

	public static void main(String[] args) {
		int[] a = new int[10];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 10; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 9; i >= 0; i--) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
