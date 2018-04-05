package com.gient.printABC;

public class Client {

	public static void main(String[] args) {
		Printer printer = new Printer();
		PrintTaskA taskA = new PrintTaskA(printer);
		PrintTaskB taskB = new PrintTaskB(printer);
		PrintTaskC taskC = new PrintTaskC(printer);
		new Thread(taskA,"A").start();
		new Thread(taskB,"B").start();
		new Thread(taskC,"C").start();
	}
	
}
