package yingcai;

import java.util.Scanner;

public class Y1043 {

	public static void main(String[] args) {
		int n;
		int[] a = new int[7];
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		while(scanner.hasNext()) {
			for(int i = 0;i < 7; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 7 - i -1; j++) {
					if(a[j] > a[j+1]) {
						int t = a[j];
						a[j] = a[j+1];
						a[j+1] = t;
					}
				}
			}
			for(int i = 0; i < 7; i++) {
				System.out.print(a[i] + " ");
			}
		}
		scanner.close();
	}

}