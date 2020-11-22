package com.hnuahe.soft02;

import java.util.Scanner;

public class C1148 {

	public static void main(String[] args) {
		int[][] aa = new int[3][3];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 3 ;i++) {
				for(int j = 0; j < 3;j++) {
					aa[i][j] = scanner.nextInt();
				}
			}
			for(int i = 0; i < 3 ;i++) {
				for(int j = 0; j < 3;j++) {
					System.out.print(aa[j][i] + " ");
				}
				System.out.println();
			}
		}
		scanner.close();
	}

}
