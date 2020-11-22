package com.hnuahe.soft02;

import java.util.Scanner;

public class J1051 {

	public static void main(String[] args) {
		String n;
		int a;
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		while(a > 0) {
			a--;
			int b = 0;
			n = scanner.next();
			char[] ch = n.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				if(ch[i] >= '0' && ch[i] <= '9') {
					b++;
				}
			}
			System.out.println(b);
		}
		scanner.close();
	}

}
