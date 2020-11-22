package com.hnuahe.soft02;

import java.text.DecimalFormat;

import java.util.Scanner;

public class Main1062jiandan {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < a.length; i++) {
				a[i] = scanner.nextInt();
			}
			double k = 0;
			for(int i = 0; i < a.length; i++) {
				if(a[i] < 60) {
					k++;
				}
			}
			DecimalFormat df = new DecimalFormat("0.00%");
			String r = df.format(k/a.length);//小数换百分数
			System.out.println(r);
		}
		scanner.close();
	}

}
