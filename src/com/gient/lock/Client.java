package com.gient.lock;

/**
 * 测试售票客户端
 * 
 * @author gient
 *
 */
public class Client {

	public static void main(String[] args) {
		TicketsTask task = new TicketsTask();
		new Thread(task, "1号窗口 ").start();
		new Thread(task, "2号窗口").start();
		new Thread(task, "3号窗口").start();
	}
}
