package com.gient.pool;

import java.util.Random;

/**
 * 线程任务
 * 
 * @author gient
 *
 */
public class PoolTask implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

}
