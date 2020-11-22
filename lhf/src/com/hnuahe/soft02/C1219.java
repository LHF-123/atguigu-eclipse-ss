package com.hnuahe.soft02;

import java.util.Scanner;

public class C1219 {

	public static void main(String[] args) {
		int m;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			double t = 0;
			m = scanner.nextInt();
			for(int i = 1; i <= m; i++) {
				if(i == 1) {
					t = 0;
				}
				t += (double)-1/(i * i);
			}
			System.out.printf("%.6f",t+2);
			System.out.println();
		}
		scanner.close();
	}

}
