package yingcai;

import java.util.Scanner;

public class Y1079 {

	public static void main(String[] args) {
		int[] a = new int[3];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 3; i++) {
				a[i] = scanner.nextInt();
			}
			int max = 0;
			for(int i = 0; i < 3; i++) {
				if(a[i] > max) {
					max = a[i];
				}
			}
			System.out.println(max);
		}
		scanner.close();
	}

}
