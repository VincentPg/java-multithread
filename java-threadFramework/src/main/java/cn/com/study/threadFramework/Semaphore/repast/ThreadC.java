package cn.com.study.threadFramework.Semaphore.repast;

public class ThreadC extends Thread {

	private RepastService service;

	public ThreadC(RepastService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.get();
	}

}
