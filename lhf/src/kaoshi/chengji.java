package kaoshi;

import java.util.Scanner;
public class chengji {
	public static void main(String[] args) {
		int a,b,c;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		if(a<0 || a>100) 
			System.out.println("Score is error");
		else {
			if(b<50 || c<60 || (a/2)+(c/2)<60 ) 
				System.out.println("E");
			else if((a/2)+(c/2)<70)
				System.out.println("D");
			else if((a/2)+(c/2)<80)
				System.out.println("C");
			else if((a/2)+(c/2)<90) 
				System.out.println("B");
			else 
			System.out.println("A");				
			}	
			}
		scanner.close();
		}	
	}

