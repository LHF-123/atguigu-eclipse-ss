package com.hnuahe.soft02;

import java.util.Scanner;

public class Cyuyanxinshengsai3 {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		while(n>0) {
			n--;
			int sum = 0;
			int k = scanner.nextInt();
			int[] a = new int[k];
			for(int j = 0; j < a.length ;j++) {
				a[j] = scanner.nextInt();
				sum += a[j];
			}
			System.out.println(sum);
			
		}
		scanner.close();
	}

}
