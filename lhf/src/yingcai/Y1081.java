package yingcai;

import java.util.Scanner;

public class Y1081 {

	public static void main(String[] args) {
		int a;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = scanner.nextInt();
			System.out.print(a * a + " ");
			System.out.print(a * a * a + " ");
			System.out.print(a * a * a * a + " ");
		}
		scanner.close();
	}

}
