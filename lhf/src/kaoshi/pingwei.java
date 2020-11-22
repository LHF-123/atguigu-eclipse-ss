package kaoshi;

import java.util.Scanner;
public class pingwei {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			while(scanner.hasNext()) {
				int n =scanner.nextInt();
				double [] a = new double [n];
				for (int i = 0; i < n; i++) {
					a[i]=scanner.nextDouble();
				}
				double max,min,sum1;
				max = min = a[0];
				for (int i = 0; i < n; i++) {
					if(a[i]>max) {
						max=a[i];
					}
				}
				for (int i = 0; i < n; i++) {
					if(a[i]<min) {
						min=a[i];
					}
				}
				int  sum = 0;
				for (int i = 0; i < n; i++) {
					sum+=a[i];
				}
				sum1=sum-min-max;
				double p = sum1/(n-2);
			    double b = 100;
				for (int i = 0; i < n; i++) {
					if(Math.abs(a[i] - p) < b)
						b = Math.abs(a[i] - p);				
				}
				for (int i = 0; i < n; i++) {
					if(b == Math.abs(a[i] - p))
						System.out.print(i+1 + " ");				
				}
			}
			scanner.close();
		}

	}

