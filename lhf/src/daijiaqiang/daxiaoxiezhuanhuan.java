package daijiaqiang;

import java.util.Scanner;

public class daxiaoxiezhuanhuan {

	public static void main(String[] args) {
		String string;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			string = scanner.nextLine();
			char[] ch = string.toCharArray();
			for(int i = 0; i < ch.length; i++) {
				char str = string.charAt(i);
				if(ch[i] >= 'a' && ch[i] <= 'z') {
					str = (char) (str - 32);
					System.out.print(str);
				}
				if(ch[i] >= 'A' && ch[i] <= 'Z') {
					str = (char) (str + 32);
					System.out.print(str);
				}
			}
			System.out.println();
		}
		scanner.close();
	}

}
