package com.hnuahe.soft02;

import java.util.Scanner;

public class J1050 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < a.length; i++) {
				a[i] = scanner.nextInt();
			}
			int max = a[0], min = a[0];
			double sum = 0;
			for(int i = 0; i < a.length; i++) {
				sum += a[i];
				if(max < a[i]) {
					int t = max;
					max = a[i];
					a[i] = t;
				}
				if(min > a[i]) {
					int t = min;
					min = a[i];
					a[i] = t;
				}
			}
			System.out.println(String.format("%.2f", (sum - max - min)/(a.length - 2)));
		}
		scanner.close();
	}

}
