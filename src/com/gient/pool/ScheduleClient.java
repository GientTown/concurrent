package com.gient.pool;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleClient {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// 创建线程任务
		PoolTask task = new PoolTask();
		int num = new Random().nextInt(10);

		// 创建线程池
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

		// 提交任务
		for (int i = 0; i < 10; i++) {
			ScheduledFuture<?> future = pool.schedule(task, 2, TimeUnit.SECONDS);
			future.get();
		}

		// 关闭线程池
		pool.shutdown();
	}
}
