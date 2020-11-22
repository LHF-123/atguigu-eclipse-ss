package ceshi;

public interface USB {
	
	public void start();
	public void working();
	public void stop();
	
}
class Printer implements USB{

	@Override
	public void start() {
		System.out.println("打印机已准备就绪");
	}

	@Override
	public void working() {
		System.out.println("打印机正在工作：咔、咔...");
	}

	@Override
	public void stop() {
		System.out.println("打印机停止了工作");
	}
	
}
class Camera implements USB {

	@Override
	public void start() {
		System.out.println("照相机已准备就绪");
	}

	@Override
	public void working() {
		System.out.println("照相机正在工作：咔嚓、咔嚓...");
	}

	@Override
	public void stop() {
		System.out.println("照相机停止了工作");
	}
	
}