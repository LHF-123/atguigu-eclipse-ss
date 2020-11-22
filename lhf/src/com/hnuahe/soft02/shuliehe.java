package com.hnuahe.soft02;

import java.util.Scanner;

public class shuliehe {

	public static void main(String[] args) {
		int n, i, sum;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			if(n <= 1000) {
				sum = 0;
				 for(i = 1; i <= n; i++){
					sum += i*i;
					}
					System.out.println(sum);
			}
		}
		scanner.close();
	}

}
