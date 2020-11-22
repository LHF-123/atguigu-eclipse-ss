package com.hnuahe.soft02;

public class chubujindeshu {

	public static void main(String[] args) {
		int a;
		for(a = 0;;a++) {
		    if(a % 8 == 1 && a/8%8==1 && a/8/8%8==7
				&& a % 17 == 4 && a/17%17==15 && a/17/17==2*(a/8/8/8)) {
		    	System.out.println(a);
		    break;
		    }
		}
	}
}
