package com.hnuahe.soft02;

import java.util.Scanner;

public class houzichitao {

	public static void main(String[] args) {
		int n, m = 0 ,i;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
		n = scanner.nextInt();
		    m = 1;
			for(i = 1;i <= n-1; i++) {
				m = (1 + m) * 2;
			}if(n >= 1 && n <= 30) {
				System.out.println(m);
			}
		}
		scanner.close();
	}

}
