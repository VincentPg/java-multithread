
package cn.com.study.threadFramework.Semaphore.Pool_List;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  
 * @ClassName:  ListPool   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: penggang
 * @date:   2018年2月16日 下午12:23:46   
 * 
 **/
public class ListPool {
	
	private int poolMaxSize = 5;
	private int semaphorePermits = 5;
	private List<String> list = new ArrayList<String>();
	private Semaphore concurrencySemaphore = new Semaphore(semaphorePermits);
	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public ListPool() {
		super();
		for (int i = 0; i < poolMaxSize; i++) {
			list.add("高洪岩" + (i + 1));
		}
	}

	public String get() {
		String getString = null;
		try {
			concurrencySemaphore.acquire();
			lock.lock();
			while (list.size() == 0) {
				condition.await();
			}
			getString = list.remove(0);
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getString;
	}

	public void put(String stringValue) {
		lock.lock();
		list.add(stringValue);
		condition.signalAll();
		lock.unlock();
		concurrencySemaphore.release();
	}
}
