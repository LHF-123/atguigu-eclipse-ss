package ceshi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] a = new int[3];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 3; i++) {
				a[i] = scanner.nextInt();
			}
			int max = a[0];
			for(int i = 0;i < 3; i++) {
				if(max < a[i]) {
					max = a[i];
				}
			}
			System.out.println(max);
		}
		scanner.close();
	}

}
