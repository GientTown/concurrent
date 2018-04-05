package com.gient.printABC;

public class PrintTaskB implements Runnable {

	private Printer printer;

	public PrintTaskB(Printer printer) {
		super();
		this.printer = printer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			printer.printB();
		}
	}
}
