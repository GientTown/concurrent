package com.gient.lock;

/**
 * 生产者
 * 
 * @author gient
 *
 */
public class Productor implements Runnable {

	private Clerk clerk;

	public Productor(Clerk clerk) {
		super();
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.get();
		}
	}

}
