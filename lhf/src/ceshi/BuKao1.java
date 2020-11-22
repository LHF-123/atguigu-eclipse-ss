package ceshi;

import java.util.Arrays;
import java.util.Scanner;

public class BuKao1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[10];
		while (scanner.hasNext()) {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scanner.nextInt();
			}
			Arrays.sort(arr);
			for (int j : arr) {
				System.out.print(j + " ");
			} 
			System.out.println();
		}
		scanner.close();
		
	}

}
