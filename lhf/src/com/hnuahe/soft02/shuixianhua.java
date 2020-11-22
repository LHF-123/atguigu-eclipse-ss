package com.hnuahe.soft02;

import java.util.Scanner;

public class shuixianhua {

	public static void main(String[] args) {
		int m, n, a, b, c;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			m = scanner.nextInt();
			n = scanner.nextInt();
			if(m > n) {
				int k = m;
				m = n;
				n = k;
			}
			int j = 0;
			for(int i = m; i <= n;i++) {
				a = i / 100;
				b = i / 10 % 10;
				c = i % 10;
				if(a * a * a + b * b * b + c * c * c == i) {
					System.out.print(i+" ");
					j++;
				}
				}
			if(j == 0)
				System.out.print("no");
				System.out.println();
		}
		scanner.close();
	}

}
