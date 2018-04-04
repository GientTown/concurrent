package com.gient.CAS;

import java.util.Random;

public class Client {
	public static void main(String[] args) {
		final CompareAndSwap cas = new CompareAndSwap();
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int expectedValue = cas.get();
					boolean compareAndSet = cas.compareAndSet(expectedValue, new Random().nextInt(10));
					System.out.println(compareAndSet);
				}
			}).start();
		}
	}
}
