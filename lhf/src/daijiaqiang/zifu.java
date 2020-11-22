package daijiaqiang;
import java.util.Scanner;

public class zifu {

	public static void main(String[] args) {
		String n;
		int a;
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		while(a > 0) {
			a--;
			int b = 0;
			n = scanner.next();//
			char[] ch = n.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				if(ch[i] >= '0' && ch[i] <= '9') {
					b++;
				}
			}
			System.out.println(b);
		}
		scanner.close();
	}

}
//如何给字符串赋值？？？
//两种方法：
//	1.next(); 读取的字符串不能包含空格、tab键或回车
//	2.nextLine(); 可以包含空格和字符串，遇到回车结束