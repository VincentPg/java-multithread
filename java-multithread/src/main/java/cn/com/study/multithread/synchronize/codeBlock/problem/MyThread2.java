/**  
 * All rights Reserved, Designed By www.zzcx.com.cn
 * @Title:  MyThread2.java   
 * @Package cn.com.study.multithread.synchronize.codeBlock.problem   
 * @author: penggang
 * @date:   2018年1月30日 下午2:06:43   
 * @version V1.0 
 * @Copyright: 2018 湖南智卓创新信息产业股份有限公司. All rights reserved. 
 * 注意：本内容仅限于公司内部使用，禁止外泄以及用于其他的商业目
 * 
 **/
package cn.com.study.multithread.synchronize.codeBlock.problem;

/**  
 * @ClassName:  MyThread2   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: penggang
 * @date:   2018年1月30日 下午2:06:43   
 * 
 **/
public class MyThread2 extends Thread{

	private Task task;

	public MyThread2(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime2 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime2 = System.currentTimeMillis();
	}

}
