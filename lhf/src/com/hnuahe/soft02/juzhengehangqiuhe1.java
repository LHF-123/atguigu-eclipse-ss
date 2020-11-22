package com.hnuahe.soft02;

import java.util.Scanner;


public class juzhengehangqiuhe1 {

	public static void main(String[] args) {
		int m, n,sum;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
		m = scanner.nextInt();
		n = scanner.nextInt();
		int[][] aa = new int[m][n];
		int i, j;
		for(i = 0;i < m;i++) {
			sum = 0;
			for(j = 0; j < n;j++) {
				aa [i][j] = scanner.nextInt();
				sum += aa[i][j];
			}
			System.out.println(sum);
		}
		}
		scanner.close();
	}

}
