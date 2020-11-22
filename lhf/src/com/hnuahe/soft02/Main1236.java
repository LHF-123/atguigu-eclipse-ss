package com.hnuahe.soft02;

import java.util.Scanner;

public class Main1236 {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
        int n = scanner.nextInt();
        if(n == 0) {
            break;
        }
        int[] a;
        a = new int[n];
        for(n = 0; n < a.length; n++) {
            a[n] = scanner.nextInt();
        }
        int i, j;
        for(i = 0; i < a.length - 1; i++) {
            for(j = 0; j < a.length - i - 1; j++) {
                if(a[j]> a[j+1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        for(i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        }
        scanner.close();
    }
 
}
