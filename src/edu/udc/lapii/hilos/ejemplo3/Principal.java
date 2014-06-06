package edu.udc.lapii.hilos.ejemplo3;

public class Principal {
	public static void main(String[] args) {
				
		Buffer buffer = new Buffer();
		for (int i = 1; i <= 10; i++){
			new Thread(new Consumidor(buffer), "Consumidor" + i).start();
		}
		new Thread(new Productor(buffer)).start();
		
		
		
	}
}
