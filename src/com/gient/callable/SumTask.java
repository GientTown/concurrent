package com.gient.callable;

import java.util.concurrent.Callable;

/**
 * 计算sum，实现callable接口的线程任务
 * @author gient
 *
 */
public class SumTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=1;i<=100;i++){
			sum += i;
		}
		return sum;
	}

}
