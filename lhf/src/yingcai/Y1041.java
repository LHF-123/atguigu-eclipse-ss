package yingcai;

import java.util.Scanner;

public class Y1041 {

	public static void main(String[] args) {
		int[] a = new int[3];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0;i < 3; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 3 - i -1; j++) {
					if(a[j] > a[j+1]) {
						int t = a[j];
						a[j] = a[j+1];
						a[j+1] = t;
					}
				}
			}
			for(int i = 0; i < 3; i++) {
				System.out.print(a[i] + " ");
			}
		}
		scanner.close();
	}

}
