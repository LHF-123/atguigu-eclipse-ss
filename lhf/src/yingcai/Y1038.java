package yingcai;

import java.util.Scanner;

public class Y1038 {

	public static void main(String[] args) {
		int[] a = new int[4];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 4; i++) {
				a[i] = scanner.nextInt();
			}
			int min = a[0];
			for(int i = 0; i < 4; i++) {
				if(min > a[i]) {
					min = a[i];
				}
			}
			System.out.println(min);
		}
		scanner.close();
	}

}
