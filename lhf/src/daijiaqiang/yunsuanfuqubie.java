package daijiaqiang;

public class yunsuanfuqubie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//区分& 与 &&
				//如果符号左端是true，二者没有区别，都执行符号右边的运算
				//如果符号左端是false，&：继续执行符号右边的运算。&&：不再执行符号右边的运算
				//开发中，通常都使用&&
				boolean a1 = true;
				a1 = false;
				int num1 = 10;
				if(a1 & (num1++ > 0)){// 无论结果是true还是false，&&左右两边都会执行
					System.out.println("北京：今天有点冷");
				}else{
					System.out.println("深圳：今天有点热");
				}
				System.out.println("num1 :" + num1);


				boolean a2 = true;
				a2 = false;
				int num2 = 10;
				if(a2 && (num2++ > 0)){//a2已经是false，后面的不影响结果，&& 后面的不会执行
					System.out.println("北京：今天有点冷");
				}else{
					System.out.println("深圳：今天有点热");
				}
				System.out.println("num2 :" + num2);

				// | 与 ||
				//如果符号左端是false，二者没有区别，都执行符号右边的运算
				//如果符号左端是true，|：继续执行符号右边的运算。||：不再执行符号右边的运算
				//开发中，通常都使用||
				boolean a3 = false;
				a3 = true;
				int num3 = 10;
				if(a3 | (num3++ > 0)){// 无论结果是true还是false，&&左右两边都会执行
					System.out.println("北京：今天有点冷");
				}else{
					System.out.println("深圳：今天有点热");
				}
				System.out.println("num3 :" + num3);


				boolean a4 = false;
				a4 = true;
				int num4 = 10;
				if(a4 || (num4++ > 0)){//a2已经是false，后面的不影响结果，&& 后面的不会执行
					System.out.println("北京：今天有点冷");
				}else{
					System.out.println("深圳：今天有点热");
				}
				System.out.println("num4 :" + num4);
	}

}
