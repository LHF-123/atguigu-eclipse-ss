package ceshi;

/*
 * 	测试当两位数乘以两位数时，十位与十位相等，个位相加为10时。
 * 	积=（一个因数的十位）*（另一个因数的十位+1） 拼接上  【（一个因数的个位） * （另一个因数的个位）】
 * 	【】内的不足10时前面加0
 */
public class TestMethod1 {
	
	public static void main(String[] args) {
		for (int i = 10; i < 99; i++) {
			for (int j = 10; j < 99; j++) {
				if ((i%10) + (j%10) == 10 && (i/10) == (j/10)) {
					int qian = (i/10) * (j/10+1);
					int hou = (i%10) * (j%10);
					String hou1 = null;
					String pin = null;
					if (hou >=0 && hou <=9) {
						hou1 = "0" + hou;
						pin = ":" + qian + hou1;
					}else {
						pin = ":" + qian + hou;
					}
					String pin1 = pin.substring(1);
					int result = Integer.parseInt(pin1);
					if (!(result == i * j)) {
						System.out.println(i);
						System.out.println(j);
						System.out.println("结果不一样");
						throw new RuntimeException("结果不一样");
					}
				}
			}
		}
		System.out.println("计算完毕");
	}

}
