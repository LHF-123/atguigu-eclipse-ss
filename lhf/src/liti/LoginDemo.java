package liti;

import java.util.Scanner;

/*
 * 输入用户名和密码，判断用户名和密码是否正确，正确提示：“欢迎使用本系统”；
 * 错误提示：“用户名或密码错误”。
 * ==比较相等只能用于基本的数据类型
 * 只允许尝试三次，错误一次，提示剩余次数，错误三次时退出。
 * */
public class LoginDemo {
	public static void main(String[] args) {
		String username, password;
		Scanner sc = new Scanner(System.in);
		for (int i = 2; i >= 0; i--) {
			username = sc.nextLine();
			password = sc.nextLine();
			// System.out.println("用户名：" + username + "，密码：" + password);
			// if(username == "gyf" && password == "123") {
			if (username.trim().equalsIgnoreCase("gyf") && "123".equals(password)) { // 建议将字符串常量放在前面
				System.out.println("欢迎使用本系统！");
			} else {
				if(i == 0)
					System.out.println("已经达到最大错误次数，系统退出！");
				else
					System.out.println("用户名或密码错误！剩余" + i + "次");
			}
		}
		sc.close();
	}
}
