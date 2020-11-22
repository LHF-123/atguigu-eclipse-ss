package com.hnuahe.soft02;
import java.util.Scanner;
public class Main1199 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
		int n = scanner.nextInt();
		int[] a;
		a = new int[n];
		if(n == -1)
			break;
		for(n = 0; n < a.length; n++) {
			a[n] = scanner.nextInt();
			int max = a[0];
			for(int i = 0;i  < a.length;i++) {
				if(max < a[i]) {
					int t = a[max];
					a[max] = a[i];
					a[i] = a[max];
				}
			}
			System.out.println(a[max]);
		}
		}
		scanner.close();
	}

}
