package com.gient.atomic;

/**
 * 执行num++操作的任务
 * @author gient
 *
 */
public class IncrRunnable implements Runnable {

	private volatile int num = 0;
	
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
		return num++;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
