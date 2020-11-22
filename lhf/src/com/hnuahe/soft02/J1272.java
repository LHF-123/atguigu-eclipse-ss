package com.hnuahe.soft02;

import java.util.Scanner;

public class J1272 {

	public static void main(String[] args) {
		String string;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			string = scanner.next();
			char[] ch = string.toCharArray();
			for(int i = ch.length - 1; i >= 0; i--) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
		scanner.close();
	}

}
