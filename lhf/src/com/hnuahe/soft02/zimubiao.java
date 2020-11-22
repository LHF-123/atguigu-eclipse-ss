package com.hnuahe.soft02;

import java.util.Scanner;
public class zimubiao {
      public static void main(String[]args){     
        Scanner scanner = new Scanner(System.in);    
        while(scanner.hasNext()) {
            String str = scanner.nextLine();         
            char a = str.charAt(0);
            int i=a;
         
            if(Character.isLowerCase(a)) {
                System.out.println(i-96);
            }else
                if(Character.isUpperCase(a)) {
                    System.out.println(i-64);
                }
        }
            scanner.close();
        }
}
