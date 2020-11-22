package liti;
public class ClassOther {
	public static void main(String[] args) {
		Point1 point1 = new Point1();
		point1.show(); // 通过对象名调用非静态的成员方法
		Point1.display(point1); // 通过类名调用静态的成员方法
		Point1 point2 = point1; // point2和point1指向同一块儿堆空间
		point2.show();
		point2.setX(3);
		point2.setY(5);
		point1.show();
	}
}
class Point1{
	private int x, y;
	public Point1() {
		this(1, 1); // 调用了两个参数的构造方法，必须是第一条语句
		System.out.println("无参的构造方法");
	}
	public Point1(int x, int y){
		this.x = x;
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		System.out.println("(" + x + ", " + y + ")");
	}
	public static void display(Point1 pt) {
		System.out.println("(" + pt.x + ", " + pt.y + ")");
	}
}
