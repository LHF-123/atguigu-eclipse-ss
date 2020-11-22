package com.hnuahe.soft02;

import java.util.Scanner;

public class Cyuyanxinshengsai2 {

	public static void main(String[] args) {
		int n, k;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
		int sum = 0;
		n = scanner.nextInt();
		k = scanner.nextInt();
		for(int i = 1 ; i <= (n+k); i++) {
			sum += 3*i;
		}
		System.out.println(sum);
		}
		scanner.close();
	}

}
