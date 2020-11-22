package yingcai;

import java.util.Scanner;

public class Y1048 {

	public static void main(String[] args) {
		int n, m;
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			if(n < 0) {
				System.out.print(2 * n - 1 + " ");
			}
			if(n >= 0 && n < 3) {
				System.out.print(3 * n + 5 + " ");
			}
			if(n >=3 && n < 10) {
				System.out.print(5 * n - 3 + " ");
			}
			if(n >= 10) {
				System.out.print(7 * n + 2 + " ");
			}
		}
		scanner.close();
	}

}
