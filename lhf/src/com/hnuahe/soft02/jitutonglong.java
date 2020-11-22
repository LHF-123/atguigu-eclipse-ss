package com.hnuahe.soft02;

import java.util.Scanner;;

public class jitutonglong {
    public static void main(String[] args) {
        int x, y,n;
        int head, foot;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
        n=sc.nextInt();
        for(int i=0;i<n;i++) {
        head = sc.nextInt();
        foot = sc.nextInt();
        if (foot % 2 == 0) {
            x = 2 * head - foot / 2;
            y = head - x;
            if (x >= 0 && y >= 0) {
                System.out.println(x + " " + y);
            } else {
                System.out.println("No answer");
            }
           }
         }
             
        }
        sc.close();
    }
}

