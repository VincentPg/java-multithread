/**  
 * All rights Reserved, Designed By www.zzcx.com.cn
 * @Title:  Run.java   
 * @Package cn.com.study.threadFramework.Semaphore.acquireUninterruptibly_2   
 * @author: penggang
 * @date:   2018��2��15�� ����7:28:01   
 * @version V1.0 
 * @Copyright: 2018 ������׿������Ϣ��ҵ�ɷ����޹�˾. All rights reserved. 
 * ע�⣺�����ݽ����ڹ�˾�ڲ�ʹ�ã���ֹ��й�Լ�������������ҵĿ
 * 
 **/
package cn.com.study.threadFramework.Semaphore.acquireUninterruptibly_2;

/**  
 * @ClassName:  Run   
 * @Description:Java������̺��ķ������� --�ߺ��� P10  
 * @author: penggang
 * @date:   2018��2��15�� ����7:28:01   
 * 
 **/
public class Run {
	
	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		Thread.sleep(1000);

		b.interrupt();
		System.out.println("main�ж���a");
	}
}