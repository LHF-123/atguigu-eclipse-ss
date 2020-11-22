package com.hnuahe.soft02;

import java.util.Scanner;

public class yidongshuzi {

	public static void main(String[] args) {
		int n , m;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n ; i++) {
				a[i] = scanner.nextInt();
			}
				m = scanner.nextInt();
				for(int i = n - m; i < n; i++) {
					System.out.print(a[i] + " ");
				}
				for(int i = 0; i < n - m; i++) {
					System.out.print(a[i] + " ");
				}
				System.out.println();
		}
		scanner.close();
	}

}
