package com.gient.printABC;

public class PrintTaskA implements Runnable {

	private Printer printer;

	public PrintTaskA(Printer printer) {
		super();
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			printer.printA();
		}
	}
}
