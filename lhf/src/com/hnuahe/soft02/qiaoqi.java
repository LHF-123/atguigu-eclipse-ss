package com.hnuahe.soft02;

import java.util.Scanner;

public class qiaoqi {
 
    public static void main(String[] args) {
        int a = 0,m,j;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

                j = scanner.nextInt();
                  for(m = 1; m <= j; m++) {
                     if(j <= 30000) {
                         if(m % 7 == 0 || m / 1000 == 7 || m / 100 == 7 || m / 10 == 7 || m % 1000 /100 ==7||m%100/10==7||m%10==7||m%100/10==7||m/1000%10==7||m%10000/1000==7)
                             a++;
                     }
                }
                  System.out.println(a);
     
        }
        scanner.close();
    }
 
}
