package com.gient.countDownLatch;

public class LatchTarget implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				// 打印偶数
				if (i % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + "-" + i);
				}
			}
		}
	}

}
