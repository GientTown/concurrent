package com.gient.pool;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 创建线程任务
		PoolTask task = new PoolTask();
		int num = new Random().nextInt(10);

		// 创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);

		// 提交任务
		for (int i = 0; i < 10; i++) {
			pool.submit(task);
			// System.out.println(future.get());
		}
		// System.out.println(future.get());

		// 关闭线程池
		pool.shutdown();
	}

}
