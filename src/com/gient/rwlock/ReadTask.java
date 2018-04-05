package com.gient.rwlock;

public class ReadTask implements Runnable{

	private ReadWrite rw;
	
	public ReadTask(ReadWrite rw) {
		super();
		this.rw = rw;
	}

	@Override
	public void run() {
		rw.get();
	}

}
