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
		} else {
			System.out.println(Thread.currentThread().getName() + "请上货！");
			products++;
		}
	}

	/**
	 * 售货
	 */
	public synchronized void sale() {
		if (products > 0) {
			System.out.println(Thread.currentThread().getName() + "购买");
			products--;
		} else {
			System.out.println("缺货");
		}
	}
}
