package com.gient.printABC;

public class PrintTaskC implements Runnable {

	private Printer printer;
	
	public PrintTaskC(Printer printer) {
		super();
		this.printer = printer;
	}

	@Override
	public void run() {
		for(int i=0;i<2;i++){
			printer.printC();
		}
	}
}
