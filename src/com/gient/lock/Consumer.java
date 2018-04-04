package com.gient.lock;

/**
 * 消费者
 * 
 * @author gient
 *
 */
public class Consumer implements Runnable {

	private Clerk clerk;

	public Consumer(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}

}
