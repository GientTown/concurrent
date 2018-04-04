package com.gient.CAS;

/**
 * 模拟CAS算法
 * 
 * @author gient
 *
 */
public class CompareAndSwap {

	// 模拟从内存中获的取值
	private int value;

	// 获取值
	public synchronized int get() {
		return value;
	}

	/**
	 * 比较
	 * 
	 * @param expectedValue
	 *            预估值
	 * @param newValue
	 *            新值
	 * @return
	 */
	public synchronized int compareAndSwap(int expectedValue, int newValue) {
		int oldValue = value;
		// 比较旧值和期望值
		if (oldValue == expectedValue) {
			// 将新值赋给内存中的value
			this.value = newValue;
		}
		System.out.println(oldValue + "-" + expectedValue + "-" + newValue);
		return oldValue;
	}

	/**
	 * 设置
	 * 
	 * @param expectedValue
	 *            预估值
	 * @param newValue
	 *            新值
	 * @return true:设置成功， false:设置失败
	 */
	public synchronized boolean compareAndSet(int expectedValue, int newValue) {
		return expectedValue == compareAndSwap(expectedValue, newValue);
	}
}
