/**  
 * All rights Reserved, Designed By www.zzcx.com.cn
 * @Title:  RepastService.java   
 * @Package cn.com.study.threadFramework.Semaphore.repast   
 * @author: penggang
 * @date:   2018年2月16日 下午12:38:16   
 * @version V1.0 
 * @Copyright: 2018 湖南智卓创新信息产业股份有限公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 * 
 **/
package cn.com.study.threadFramework.Semaphore.repast;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ClassName:  RepastService   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: penggang
 * @date:   2018年2月16日 下午12:38:16   
 * 
 **/
public class RepastService {

	volatile private Semaphore setSemaphore = new Semaphore(10);// 厨师
	volatile private Semaphore getSemaphore = new Semaphore(20);// 就餐者
	volatile private ReentrantLock lock = new ReentrantLock();
	volatile private Condition setCondition = lock.newCondition();
	volatile private Condition getCondition = lock.newCondition();
	volatile private Object[] producePosition = new Object[4];

	private boolean isEmpty() {
		boolean isEmpty = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] != null) {
				isEmpty = false;
				break;
			}
		}
		if (isEmpty == true) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isFull() {
		boolean isFull = true;
		for (int i = 0; i < producePosition.length; i++) {
			if (producePosition[i] == null) {
				isFull = false;
				break;
			}
		}
		return isFull;
	}

	public void set() {
		try {
			// System.out.println("set");
			setSemaphore.acquire();// 允许同时最多有10个厨师进行生产
			lock.lock();
			while (isFull()) {
				// System.out.println("生产者在等待");
				setCondition.await();
			}
			for (int i = 0; i < producePosition.length; i++) {
				if (producePosition[i] == null) {
					producePosition[i] = "数据";
					System.out.println(Thread.currentThread().getName()
							+ " 生产了 " + producePosition[i]);
					break;
				}
			}
			getCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			setSemaphore.release();
		}
	}

	public void get() {
		try {
			// System.out.println("get");
			getSemaphore.acquire();// 允许同时最多有16个就餐者
			lock.lock();
			while (isEmpty()) {
				// System.out.println("消费者在等待");
				getCondition.await();
			}
			for (int i = 0; i < producePosition.length; i++) {
				if (producePosition[i] != null) {
					System.out.println(Thread.currentThread().getName()
							+ " 消费了 " + producePosition[i]);
					producePosition[i] = null;
					break;
				}
			}
			setCondition.signalAll();
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			getSemaphore.release();
		}
	}

}
