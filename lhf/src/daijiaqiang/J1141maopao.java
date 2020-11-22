package daijiaqiang;

import java.util.Scanner;

public class J1141maopao {

	public static void main(String[] args) {
		int[] a = new int[10];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 10; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 10-i-1; j++) {
					if(a[j] > a[j+1]) {
						int t = a[j];
						a[j] = a[j+1];
						a[j+1] = t;
					}
				}
			}
			for(int k = 0; k < 10; k++) {
				System.out.println(a[k]);
			}
		}
		scanner.close();
	}

}
