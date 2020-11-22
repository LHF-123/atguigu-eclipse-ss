package yingcai;

import java.util.Scanner;

public class Y1049 {

	public static void main(String[] args) {
		int n, m;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			int sum = 0;
			for(int i = n; i <= m; i++) {
				sum += i;
			}
			System.out.println(sum);
		}
		scanner.close();
	}

}
