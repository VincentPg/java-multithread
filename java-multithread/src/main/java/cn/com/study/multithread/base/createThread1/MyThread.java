/**  
 * All rights Reserved, Designed By www.zzcx.com.cn
 * @Title:  MyThread.java   
 * @Package cn.com.study.multithread.base.createThread1   
 * @author: penggang
 * @date:   2018��1��28�� ����8:43:03   
 * @version V1.0 
 * @Copyright: 2018 ������׿������Ϣ��ҵ�ɷ����޹�˾. All rights reserved. 
 * ע�⣺�����ݽ����ڹ�˾�ڲ�ʹ�ã���ֹ��й�Լ�������������ҵĿ
 * 
 **/
package cn.com.study.multithread.base.createThread1;

/**  
 * @ClassName:  MyThread   
 * @Description:TODO(������һ�仰��������������)   
 * @author: penggang
 * @date:   2018��1��28�� ����8:43:03   
 * 
 **/
public class MyThread extends Thread{
	public void run() {
		super.run();
		System.out.println("current Thread:" + Thread.currentThread().getName());
	}
}