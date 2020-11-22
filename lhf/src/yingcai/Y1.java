package yingcai;

import java.util.Scanner;

public class Y1 {

	public static void main(String[] args) {
		int a = 0;
		String string;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			string = scanner.nextLine();
			char[] ch = string.toCharArray();
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == ' ') {
					a++;
				}
			}
			System.out.println(a);
		}
		scanner.close();
	}

}
