package com.hnuahe.soft02;

import java.util.Scanner;

public class J1233 {

	public static void main(String[] args) {
		int x, y;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			int sum = 0;
			for(int i = x; i <= y; i++) {
				if(i%3==1 && i%5==3) {
				   sum += i;
				}
			}
			System.out.println(sum);
		}
		scanner.close();
	}

}
