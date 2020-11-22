package com.hnuahe.soft02;

import java.util.Scanner;

public class J1104 {

	public static void main(String[] args) {
		double n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextDouble();
			if(n < 0) {
				n = -n;
				System.out.println(String.format("%.8f", n));
			}else {
				System.out.println(String.format("%.8f", n));
			}
		}
		scanner.close();
	}

}
