package com.gient.copy_on_write;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 测试并发迭代的线程任务
 * 
 * @author gient
 *
 */
public class Target implements Runnable {

	private static List<String> list = 
			Collections.synchronizedList(new ArrayList<>());

	// 初始化list
	static {
		list.add("AA");
		list.add("BB");
		list.add("CC");
	}

	@Override
	public void run() {
		//获取迭代器
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String string = (String) it.next();
			System.out.println(string);
			
			//添加
			list.add("gient-" + new Random().nextInt(10));
		}
	}

}
