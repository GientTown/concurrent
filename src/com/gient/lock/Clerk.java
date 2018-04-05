package com.gient.lock;

/**
 * 售货职员
 * 
 * @author gient
 *
 */
public class Clerk {

	private int products = 0;
	private int proCount = 1;
	private int CsuCount = 1;

	/**
	 * 进货，生产者
	 */
	public synchronized void get() {

		System.out.println("第" + (proCount++) + "次生产+循环");

		while (products >= 10) {
			System.out.println("货架已满，请稍后上货！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "正在上货！" + (++products));
		this.notifyAll();
	}

	/**
	 * 售货，消费者
	 */
	public synchronized void sale() {

		System.out.println("第" + (CsuCount++) + "次消费-循环");

		while (products <= 0) {
			System.out.println("缺货");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "购买" + (products--));
		this.notifyAll();
	}
}
