package com.hnuahe.soft02;

import java.util.Scanner;

public class tongjizifu {

	public static void main(String[] args) {
		int a, b, c, d;
		String string;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			a = b = c = d = 0;
			string = scanner.nextLine();
			char[] chs = string.toCharArray();
			for(int i = 0; i < chs.length; i++) {
				if(chs[i] >= 'A' && chs[i] <= 'Z' || chs[i] >= 'a' && chs[i] <= 'z') {
					a++;
				}else if(chs[i] == ' ') {
					b++;
				}else if(chs[i] >= '0' && chs[i] <= '9'){
					c++;
				}else {
					d++;
				}
			}
			System.out.println(a + " " + b + " " + c + " " + d);
		}
		scanner.close();
	}

}
