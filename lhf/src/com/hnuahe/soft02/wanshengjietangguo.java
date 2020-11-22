package com.hnuahe.soft02;

import java.util.Scanner;

public class wanshengjietangguo {

	public static void main(String[] args) {
		int a1, a2, a3, a4;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a1 = scanner.nextInt();
			a2 = scanner.nextInt();
			a3 = scanner.nextInt();
			a4 = scanner.nextInt();
				if(a1 + a2==a3+a4||a1+a3==a2+a4||a1+a4==a2+a3||a1==a2+a3+a4||a2==a1+a3+a4||a3==a1+a2+a4||a4==a1+a2+a3) { 
					System.out.println("YES");}
					else {
						System.out.println("NO");
				}
				
		}
		scanner.close();
	}
}
