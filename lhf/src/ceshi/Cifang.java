package ceshi;

import java.util.Scanner;

public class Cifang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			int sum = 0;
			int a = 1;
			for(int i = 0; i < n; i++) {
				sum += a;
				a = a * 2;
			}
			System.out.println(sum);
			
		}
		scanner.close();
	}

}
