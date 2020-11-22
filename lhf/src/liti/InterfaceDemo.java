package liti;

public class InterfaceDemo {
	public static void main(String[] args) {
//		USB usb = new USB(); 错误，原因：接口不能实例化
//		USBDisk disk = new USBDisk();
		USB usb = new USBDisk();
		usb.start();
		usb.work();
		usb.stop();
		System.out.println("==================");
//		USBCamera camera = new USBCamera();
		usb = new USBCamera(); // 统一使用了usb接口的引用
		usb.start();
		usb.work();
		usb.stop();
	}
}
interface USB{ // 是一套规范，或说是一套规则
	public static String name = null;
	public abstract void start(); // 方法的声明，没有大括号：方法体
	void work(); // 在接口中，方法默认是公有的、抽象的
	abstract void stop();
}
// 一个类实现接口时，必须实现接口所有的抽象方法
class USBDisk implements USB{
	public void start() {
		System.out.println("U盘正在启动中……");
	}
	public void work() {
		System.out.println("U盘正在工作中……");
	}
	public void stop() {
		System.out.println("U盘正在停止工作……");
	}
}
class USBCamera implements USB{
	public void start() {
		System.out.println("USB摄像头正在启动……");
	}
	public void work() {
		System.out.println("USB摄像头正在工作……");
	}
	public void stop() {
		System.out.println("USB摄像头正在停止工作……");
	}
}