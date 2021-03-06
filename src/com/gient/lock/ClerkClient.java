package com.gient.lock;

/**
 * 客户端
 * 
 * @author gient
 *
 */
public class ClerkClient {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor productor = new Productor(clerk);
		Consumer consumer = new Consumer(clerk);
		
		new Thread(productor,"生产者1+").start();
		new Thread(consumer,"消费者1-").start();
		new Thread(productor,"生产者2+").start();
		new Thread(consumer,"消费者2-").start();
		new Thread(productor,"生产者3+").start();
		new Thread(consumer,"消费者3-").start();
	}
}
