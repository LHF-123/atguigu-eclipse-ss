package com.hnuahe.soft02;

import java.util.Scanner;

public class xiaomingdeweizhi {

	public static void main(String[] args) {
		int n,k;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			int[] a = new int[n];
			for(int j = 0; j<n; j++) {
				a[j] = scanner.nextInt();
			}
			k = scanner.nextInt();
			System.out.println(k);
			
		}
		scanner.close();
	}

}
