package com.gient.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class LatchTarget implements Runnable {

	private CountDownLatch latch;

	public LatchTarget() {
		super();
	}

	public LatchTarget(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				for (int i = 0; i < 100; i++) {
					// 打印偶数
					if (i % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + "-" + i);
					}
				}
			} finally {
				latch.countDown();
			}
		}
	}

}
