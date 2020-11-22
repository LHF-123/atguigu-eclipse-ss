package com.hnuahe.soft02;

import java.util.Scanner;

public class zhaoqi {

	public static void main(String[] args) {
		int n, m ,i ,j;
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			for(i = 1; i <= n; i++) {
				j = scanner.nextInt();
				  for(m = 1; m <= j; m++) {
				     if(j <= 30000) {
				    	 if(m % 7 == 0 || m / 1000 == 7 || m / 100 == 7 || m / 10 == 7 || m % 1000 /100 ==7||m%100/10==7||m%10==7||m%100/10==7||m/1000%10==7||m%10000/1000==7)
				    		 System.out.print(m + " ");
				     }
				}
				  System.out.println();
			}
		}
		scanner.close();
	}

}
