package com.hnuahe.soft02;

import java.util.Scanner;

public class shuzimu {

	public static void main(String[] args) {
		int a;
		String string;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = 0;
			string = scanner.nextLine();
			char[] chs = string.toCharArray();
			for(int i = 0; i < chs.length; i++) {
				if(chs[i] >= 'A' && chs[i] <= 'Z' || chs[i] >= 'a' && chs[i] <= 'z') {
					a++;
			}
		}
			System.out.println(a);
			break;
		}
		scanner.close();
	}

}
