package com.hnuahe.soft02;

import java.util.Scanner;

public class wujizhichengji {

	public static void main(String[] args) {
		int t, n;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			t = scanner.nextInt();
			n = t/10;
			switch (n) {
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
		scanner.close();
	}

}
