package com.gient.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 测试Callable接口客户端
 * 
 * @author gient
 *
 */
public class Client {
	public static void main(String[] args) {
		
		SumTask task = new SumTask();
		
		//用于接收实现Callable接口的线程任务运算后的结果
		FutureTask<Integer> futureTask = new FutureTask<>(task);
		
		new Thread(futureTask).start();
		
		//接收线程运行后的运算结果
		try {
			Integer sum = futureTask.get(); //可用于闭锁
			System.out.println("----------");
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
}
