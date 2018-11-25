package cn.com.study.threadFramework.Semaphore.MoreToOne_2;

public class MyThread extends Thread {

	private Service service;

	public MyThread(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.sayHello();
	}

}
