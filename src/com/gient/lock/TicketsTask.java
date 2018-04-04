package com.gient.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 售票线程任务
 * @author gient
 *
 */
public class TicketsTask implements Runnable {

	private int tickets = 100;
	//同步锁
	private Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while (true) {
			//上锁
			lock.lock();
			
			try {
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "正在售票，剩余：" + (--tickets) + "张");
				} 
			} finally {
				//释放锁
				lock.unlock();
			}
		}
	}

}
