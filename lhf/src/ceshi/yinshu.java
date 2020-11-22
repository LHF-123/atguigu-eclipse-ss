package ceshi;

public class yinshu {

	public static void main(String[] args) {
		int a,b;
		for(a = 0; a <= 36;a++) {
			for(b = 0; b <= 36; b++) {
				if (a * b == 36 && a <= b) {
					System.out.println(a + "和" + b);
				}
			}
		}
	}

}
