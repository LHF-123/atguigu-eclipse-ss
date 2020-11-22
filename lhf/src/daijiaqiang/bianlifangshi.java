package daijiaqiang;

import java.util.Arrays;

public class bianlifangshi {

	public static void main(String[] args) {
		int[] arr1 = new int[] {1,6,5,8,10,7,12}; 
		
		//遍历的两种方式
		//1
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		//2
		System.out.println(Arrays.toString(arr1));
		
	}

}
