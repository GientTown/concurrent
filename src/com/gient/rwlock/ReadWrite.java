package com.gient.rwlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {

	private int number = 0;
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	//读
	public void get(){
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "--" + number);
		} finally {
			lock.readLock().unlock();
		}
	}
	
	//写
	public void set(int num){
		lock.writeLock().lock();
		
		try {
			System.out.println("正在写入...");
			this.number = num;
			
		} finally {
			lock.writeLock().unlock();
		}
	}
	
}
