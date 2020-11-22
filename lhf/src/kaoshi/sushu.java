package kaoshi;

import java.util.Scanner;

public class sushu {

	public static void main(String[] args) {
		int n, m;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			if (n < m) {
				for (int i = n; i <= m; i++) {
					for (int j = 2; j <= i; j++) {
						if (i % j == 0 && i != j) {
							break;
						}
						if (i == j) {
							System.out.print(i + " ");
						}
					}
				}
			}
			if (n > m) {
				for (int i = n; i >= m; i--) {
					for (int j = 2; j <= i; j++) {
						if (i % j == 0 && i != j) {
							break;
						}
						if (i == j) {
							System.out.print(i + " ");
						}
					}
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
