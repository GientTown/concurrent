package com.gient.lock;

/**
 * 售货职员
 * 
 * @author gient
 *
 */
public class Clerk {

	private int products = 5;

	/**
	 * 进货
	 */
	public synchronized void get() {
		if (products >= 10) {
			System.out.println("货架已满，请稍后上货！");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "正在上货！");
			products++;
			this.notifyAll();
		}
	}

	/**
	 * 售货
	 */
	public synchronized void sale() {
		if (products <= 0) {
			System.out.println("缺货");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "购买");
			products--;
			this.notifyAll();
		}
	}
}
