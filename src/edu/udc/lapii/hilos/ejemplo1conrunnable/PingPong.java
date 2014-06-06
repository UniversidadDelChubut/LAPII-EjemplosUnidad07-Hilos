package edu.udc.lapii.hilos.ejemplo1conrunnable;

public class PingPong implements Runnable {
	
	private String palabra;
	private int lapso;
	
	public PingPong(String palabra, int lapso) {
		this.palabra = palabra;
		this.lapso = lapso;
	}
	
	@Override
	public void run() {
		for(;;){
			System.out.println(this.palabra);
			try {
				Thread.sleep(this.lapso);
			} catch (InterruptedException e) {;}
		}
	}
	
	public static void main(String[] args) {
	
		Thread t1 =  new Thread(new PingPong("DALE", 1000));
		Thread t2 =  new Thread(new PingPong("ÑULL", 1020));
		t1.start();
		t2.start();
	}
	
	
}

