package yingcai;

import java.util.Scanner;

public class Y1037 {

	public static void main(String[] args) {
		double n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextDouble();
			if(n >= 0 && n <= 150) {
				System.out.printf("%.1f",n * 0.4463);
			}
			if(n >= 151 && n <= 400) {
				System.out.printf("%.1f",150 * 0.4463 + (n-150) * 0.4663);
			}
			if(n >= 401) {
				System.out.printf("%.1f",150 * 0.4463 + 250 * 0.4663 + (n-400) * 0.5663);
			}
		}
		scanner.close();
	}

}
