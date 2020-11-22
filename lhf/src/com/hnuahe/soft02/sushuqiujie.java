package com.hnuahe.soft02;

import java.util.Scanner;

public class sushuqiujie {

	public static void main(String[] args) {
		int a, b;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			a = scanner.nextInt();
			b = scanner.nextInt();
			if (a > b) {
				int c = a;
				a = b;
				b = c;
			}
			if (printprime(a, b))
				System.out.println();
			else
				System.out.println("Not Found.");

		}
		scanner.close();
	}

	public static boolean printprime(int m, int n) {
		int i, j;
		boolean hasPrime = false;
		for (i = m; i <= n; i++) {
			for (j = 2; j <= i; j++) {
				if (i % j == 0)
					break;
			}
			if (i == j) {
				System.out.print(i + " ");
				hasPrime = true;

			}
		}
		return hasPrime;
	}
}
