package com.hnuahe.soft02;

import java.util.Scanner;

public class shuzhitongji {

	public static void main(String[] args) {
	    int n, m, a, i, b, c;
		    Scanner scanner = new Scanner(System.in);
		    while (scanner.hasNext()) {
		    	n = scanner.nextInt();
		    	a = 0;
		    	b = 0;
		    	c = 0;
		    	for(i = 1; i <= n; i++) {
		    		m = scanner.nextInt();
		    		if(m < 0) {
		    			a++;
		    		}else if(m == 0){
		    			b++;
		    		}else if(m > 0) {
		    			c++;
		    		}
		    	}
		    		if(n > 100 || a + b + c != n) {
		    			break;
		    		
		    	}
		    	System.out.println(a + " " + b + " " + c);

		    
		    }
		    scanner.close();
	} 
	}

