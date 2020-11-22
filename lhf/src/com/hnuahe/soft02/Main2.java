package com.hnuahe.soft02;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        float n;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
        n = scanner.nextFloat();
        for (int a = 1; a <= 3; a++) {	
             for (int i = 1; i <= a; i++) {
                   System.out.printf("%6.2f   ",n);
        }
             System.out.println();
        }
        }
        scanner.close();
    }
}