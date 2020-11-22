package com.hnuahe.soft02;

import java.util.Scanner;

public class chengjizhuanhuan {

	public static void main(String[] args) {
		int n, m;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			if(n < 0 || n > 100) {
				System.out.println("Score is error!");
			}
			if(m < 50 && n >=0 && n <= 100) {
				System.out.println("E");
			}
			if(m >= 50 && n >=0 && n <= 100) {
				int t = n / 10;
				switch (t) {
				case 9: case 10:
					System.out.println("A");
					break;
				case 8:
					System.out.println("B");
					break;
				case 7:
					System.out.println("C");
					break;
				case 6:
					System.out.println("D");
					break;
				default:
					System.out.println("E");
					break;
				}
			}
		}
		scanner.close();
	}

}
