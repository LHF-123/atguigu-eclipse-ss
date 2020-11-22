package com.hnuahe.soft02;

import java.text.DecimalFormat;
import java.util.Scanner;

public class J1117 {

	public static void main(String[] args) {
		double n, m, j;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextDouble();
			m = scanner.nextDouble();
			j = n / m;
			if(j > 1) {
				System.out.println("Error");
			}else if(j >= 0 && j <= 1) {
				DecimalFormat df = new DecimalFormat("0.00%");
				String r = df.format(j);
				System.out.println(r);
			}
		}
		scanner.close();
	}

}
