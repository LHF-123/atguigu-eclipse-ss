package com.hnuahe.soft02;

public class ComplexTest {
	public static void main(String[] args) {
		Complex cp1 = new Complex();
		cp1.show();
//		1. 定义一个能传递两个double类型参数的构造方法，构造对象cp2，参数：2.1，3.6
		Complex cp2 = new Complex(2.1, 3.6);
		cp2.show();
//		2. 将cp1的实部和虚部分别更新为：2.5和6.3
		cp1.setReal(2.5);
		cp1.setImag(6.3);
		cp1.show();
//		3. 将cp1和cp2相加，结果赋值给cp3，并输出cp3
		Complex cp3 = cp1.add(cp2);
		cp3.show();
//		4. 定义一个静态的方法，实现和show一样的功能
//		cp3.display(cp3); // 不建议使用此种调用形式
		Complex.display(cp3); // 建议使用类名.静态方法名调用
	}
}
class Complex{
	private double real, imag;
	
	public void setReal(double real) {
		this.real = real;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public Complex() {

	}

	public Complex(double r, double imag) {
//		super(); // 调用父类的构造方法，在此可以删除
		real = r; // this表示对象自身，谁来调用(或构造某个对象)就表示谁
		this.imag = imag; // 非静态(non-static)的方法中，都有一个隐含的this
	} // 当形参与数据成员名相同时，必须加this区分，否则可以省略this

	public Complex add(Complex cp) { // Complex表示返回值为类类型的对象
		Complex temp = new Complex();
//		调用形式：Complex cp3 = cp1.add(cp2);
//		该方法为非静态方法，有默认的this，this在此是cp1，cp是cp2
		temp.real = this.real + cp.real;
		temp.imag = this.imag + cp.imag;
		return temp;
	}
	
	public void show() { // 按照该格式输出：2.1 + 3.2i
		System.out.println(this.real + " + " + imag + "i");
	}
	
	public static void display(Complex cp) { // 静态方法中没有this，需要传参数
		System.out.println(cp.real + " + " + cp.imag + "i");
	}
}
