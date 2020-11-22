package com.hnuahe.soft02;

import java.util.Scanner;

public class yiyiliuyi {

	public static void main(String[] args) {
		int a, b, c;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			c = scanner.nextInt();
			if(a > b && b> c) {
				System.out.println(c + " "+ b +" "+a);
			}
			if(a > c && c> b) {
				System.out.println(b + " "+ c +" "+a);
			}
			if(b > a && a> c) {
				System.out.println(c + " "+ a +" "+b);
			}
			if(b > c && c> a) {
				System.out.println(a + " "+ c +" "+b);
			}
			if(c > a && a> b) {
				System.out.println(b + " "+ a +" "+c);
			}
			if(c > b && b> a) {
				System.out.println(a + " "+ b +" "+c);
			}
		}
		scanner.close();
		}

	}


