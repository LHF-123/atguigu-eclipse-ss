package liti;
public class ExceptionDemo {
	public static void main(String[] args) {
		int d = 0, a;
		try {
			System.out.println("Before throw Exception");
			int[] b = {1, 2};
			b[2] = 3; // 产生一个下标越界的异常
			a = 5 / d; // 产生异常：除0，跳过后面的语句，转到catch中查找相应异常的处理方法
			System.out.println("the Exception is throw,The statement is't run");
		} catch (ArithmeticException e) {
			System.out.println("处理算数异常的catch语句块捕获了异常！");
			System.out.println("捕获的异常为" + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("处理数组下标越异常的catch语句块捕获了异常！");
			System.out.println("捕获的异常为" + e);
		} finally {
			System.out.println("这是所有catch块的共有部分！");
		}
		System.out.println("try-catch-finally块后面的语句");
	}

}
