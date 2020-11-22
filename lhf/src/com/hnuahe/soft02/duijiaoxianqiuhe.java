package com.hnuahe.soft02;

import java.util.Scanner;

public class duijiaoxianqiuhe {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
		n = scanner.nextInt();
		int sum1 = 0,sum2 = 0;
		int[][] a = new int[n][n];
		int i, j;
		for(i = 0;i < n; i++) {
			for(j = 0; j < n; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		for(i = 0 ;i < n ;i++) {
			for(j = 0; j< n; j++) {
				if(i == j) {
				sum1 += a[i][j];
				}
			}
		}
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++) {
				if(i + j == n - 1){
				sum2 += a[i][j];
				}
			}
		}
		System.out.println(sum1 + " "+ sum2);
		}
		scanner.close();
	}

}
