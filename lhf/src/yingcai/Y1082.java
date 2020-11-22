package yingcai;

public class Y1082 {

	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			for(int j = 2; j <= i; j++) {
				if(i % j == 0 && i != j) {
					break;
				}
				if(i == j) {
					System.out.print(i + " ");
				}
			}
		}
	}

}
