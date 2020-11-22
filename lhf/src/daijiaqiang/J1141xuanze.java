package daijiaqiang;

import java.util.Scanner;

public class J1141xuanze {

	public static void main(String[] args) {
		int[] a = new int[10];
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			for(int i = 0; i < 10; i++) {
				a[i] = scanner.nextInt();
			}
			for(int i = 0; i < 10; i++) {
				int minIndex = i;
				for(int j = i; j < 10; j++) {
					if(a[j] < a[minIndex]) {
						minIndex = j;
					}
				}
				if(i != minIndex) {
					int t = a[i];
					a[i] = a[minIndex];
					a[minIndex] = t;
				}
			}
			for(int i = 0; i < 9; i++) {
				System.out.println(a[i]);
			}
		}
		scanner.close();
	}

}
