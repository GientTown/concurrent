package com.gient.rwlock;

public class Client {

	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		ReadTask readTask = new ReadTask(rw);
		WriteTask writeTask = new WriteTask(rw);
		new Thread(writeTask).start();
		new Thread(writeTask).start();
		for(int i=0;i<100;i++){
			new Thread(readTask).start();
		}
	}
	
}
