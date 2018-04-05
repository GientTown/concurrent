package com.gient.printABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Printer {

	private Lock lock = new ReentrantLock();
	private Condition conA = lock.newCondition();
	private Condition conB = lock.newCondition();
	private Condition conC = lock.newCondition();
	
	private int threadNum = 1;
	
	public void printA(){
		lock.lock();
		
		try {
			if(threadNum !=1){
				conA.await();
			}
			System.out.println(Thread.currentThread().getName());
			threadNum = 2;
			conB.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printB(){
		lock.lock();
		
		try {
			if(threadNum !=2){
				conB.await();
			}
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName());
			threadNum = 3;
			conC.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	public void printC(){
		lock.lock();
		
		try {
			if(threadNum !=3){
				conC.await();
			}
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName());
			threadNum = 1;
			conA.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
