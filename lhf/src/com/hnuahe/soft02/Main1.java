package com.hnuahe.soft02;

import java.util.Scanner;

public class Main1{

	public static void main(String[] args) {
		int[] a = new int[100];
		Scanner sc = new Scanner(System.in);
		int i, j, index, t, b;
		while (sc.hasNext()) {
		b = sc.nextInt();
		for(b = 1; b < 100; b++) {
		
		for(i = 0; i < a.length - 1; i++) {
			index = i;
			for(j = i; j < a.length; j++) {
				if(a[index] > a[j]) {
					index = j;
				}
			}
			if(index != i) {
				t = a[index];
				a[index] = a[i];
				a[i] = t;
			}
		}
		}
		for(i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		}
		sc.close();
	}

}
