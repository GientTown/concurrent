package com.gient.copy_on_write;

public class Client {

	public static void main(String[] args) {
		Target target = new Target();
		for(int i=0;i<10;i++){
			new Thread(target).start();
		}
	}
}
