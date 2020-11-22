package com.hnuahe.soft02;

import java.util.Scanner;

public class Main4cilianxi {

	public static void main(String[] args) {
		int m, n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			m = scanner.nextInt();
			n = scanner.nextInt();
			int[] a = new int[m];
			int i ;
			for(i = 0; i < a.length - 1; i++) {
				a[i] = scanner.nextInt();
			}
			int min = a[0];
			for(i = 0; i < n-1 ;i++) {
				if(min < a[i]) {
					int t = a[min];
					a[min] = a[i];
					a[i] = t;
				}
			}
				int max = a[n];
				for(i = n; i > n-1 && i < m-1;i++) {
					if(max > a[i]) {
						int t = a[max];
						a[max] = a[i];
						a[i] = t;
					}
			}
				System.out.println(a[i]);
		}
		scanner.close();
	}

}
