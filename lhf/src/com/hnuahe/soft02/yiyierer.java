package com.hnuahe.soft02;

import java.util.Scanner;

public class yiyierer {

	public static void main(String[] args) {
		float r, h;
		float C1, Sa, Sb, Va, Vb;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			r = scanner.nextFloat();
			h = scanner.nextFloat();
			C1 = 2 * 3.14f * r;
			System.out.printf("C1="+"%.2f",C1);
			System.out.println();
			Sa = 3.14f * r * r;
			System.out.printf("Sa="+"%.2f",Sa);
			System.out.println();
			Sb = 4 * 3.14f * r * r;
			System.out.printf("Sb="+"%.2f",Sb);
			System.out.println();
			Va = 4*3.14f*r*r*r/3;
			System.out.printf("Va="+"%.2f",Va);
			System.out.println();
			Vb = 3.14f * r * r * h;
			System.out.printf("Vb="+"%.2f",Vb);
			System.out.println();
		}
		scanner.close();
	}

}
