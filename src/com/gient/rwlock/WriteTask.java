package com.gient.rwlock;

import java.util.Random;

public class WriteTask implements Runnable {
	private ReadWrite rw;

	public WriteTask(ReadWrite rw) {
		super();
		this.rw = rw;
	}

	@Override
	public void run() {
		rw.set(new Random().nextInt(10));
	}

}
