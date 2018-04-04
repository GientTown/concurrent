package com.gient.atomic;

public class Client {

	public static void main(String[] args) {
		IncrRunnable runnable = new IncrRunnable();
		for(int i=0;i<10;i++){
			new Thread(runnable).start();;
		}
	}
}
