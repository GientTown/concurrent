package com.gient.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 执行num++操作的任务
 * @author gient
 *
 */
public class IncrRunnable implements Runnable {

	private  AtomicInteger num = new AtomicInteger(0);
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getNum());
	}

	public int getNum() {
		return num.getAndIncrement();
	}
}
