package kaoshi;

import java.util.Scanner;
public class zifuchuan {
    public static void main(String[] args) {
        int b;
        String str = "", a;
        Scanner sc = new Scanner(System.in);
        b = sc.nextInt();
        a = sc.nextLine();
        for (int i = 0; i < b; i++) {
            a = sc.nextLine();
            if (i > 0)
                str = str + " " + a;
            else
                str += a;
        }       
        char[] chs = str.toCharArray();
        if (chs[0] >= 'a' && chs[0] <= 'z')
            chs[0] -= 32;
        str = new String(chs);
        System.out.println(str+".");
        sc.close();
    }
}

