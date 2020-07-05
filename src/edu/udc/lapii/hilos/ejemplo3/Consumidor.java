package edu.udc.lapii.hilos.ejemplo3;

public class Consumidor implements Runnable {
	
	Buffer buffer;
	
	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	
	public void run() {
		for (;;){
			Elemento e = buffer.getElemento();
			System.out.println("Tengo el elemento " + e.getValor() + " " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}