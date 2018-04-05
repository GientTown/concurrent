package com.gient.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 售货职员
 * 
 * @author gient
 *
 */
public class Clerk {

	private int products = 0;

	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	/**
	 * 进货，生产者
	 */
	public /*synchronized*/ void get() {
		// 上锁
		lock.lock();

		try {
			while (products >= 10) {
				System.out.println("货架已满，请稍后上货！");
				try {
					// condition.signalAll();
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "正在上货！" + (++products));
			condition.signalAll();

		} finally {
			// 释放锁
			lock.unlock();
		}
	}

	/**
	 * 售货，消费者
	 */
	public /*synchronized*/ void sale() {

		// 上锁
		lock.lock();

		try {
			while (products <= 0) {
				System.out.println("缺货");
				try {
					// condition.signalAll();
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "购买" + (products--));
			condition.signalAll();

		} finally {
			// 释放锁
			lock.unlock();
		}
	}
}
