package edu.udc.lapii.hilos.ejemplo1;

public class PingPong extends Thread {
	
	private String palabra;
	private int retardo;
	
	public PingPong(String palabra, int retardo) {
		super();
		this.palabra = palabra;
		this.retardo = retardo;
	}
	
	@Override
	public void run() {
		try {
			for (;;){
				System.out.print(this.palabra + " ");
				Thread.sleep(this.retardo);
			}
		} catch (InterruptedException e) {
			return;
		}
	}
	
}
