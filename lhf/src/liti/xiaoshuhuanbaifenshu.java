package liti;

import java.text.DecimalFormat;

public class xiaoshuhuanbaifenshu {

	public static void main(String[] args) {
		   double result1=0.51111122111111;
		   DecimalFormat df = new DecimalFormat("0.00%");
		   String r = df.format(result1);
		     System.out.println(r);

	}

}
