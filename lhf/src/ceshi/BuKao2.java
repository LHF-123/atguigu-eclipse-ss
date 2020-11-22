package ceshi;

public class BuKao2 {

	public static void main(String[] args) {
		for (int i = 1000; i <= 9999; i++) {
			int a = i / 1000;
			int b = i / 100 % 10;
			int c = i / 10 % 10;
			int d = i % 10;
			if (a + c == b + d) {
				System.out.println(i);
			}
		}
	}

}
