package com.gient.countDownLatch;

/**
 * 测试多线程执行时间
 * 
 * @author gient
 *
 */
public class Client {

	public static void main(String[] args) {
		LatchTarget target = new LatchTarget();

		long start = System.currentTimeMillis();

		for (int i = 0; i < 5; i++) {
			new Thread(target).start();
		}

		long end = System.currentTimeMillis();
		//打印结果肯定不正确，因为主线程与其它线程时并行的，同时争夺cpu执行权
		System.out.println(end - start);
	}

}
