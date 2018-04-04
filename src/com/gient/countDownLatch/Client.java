package com.gient.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程执行时间
 * 
 * @author gient
 *
 */
public class Client {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(5);
		//必须是同一个闭锁
		LatchTarget target = new LatchTarget(latch);

		long start = System.currentTimeMillis();

		for (int i = 0; i < 5; i++) {
			new Thread(target).start();
		}

		// 主线程等待
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("time consuming:" + (end - start));
	}

}
