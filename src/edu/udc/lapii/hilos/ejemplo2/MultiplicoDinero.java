package edu.udc.lapii.hilos.ejemplo2;

public class MultiplicoDinero {
	
	private Cuenta cuenta;
	
	public MultiplicoDinero() {

		this.cuenta = new Cuenta(12, 300);
		new Tarea().start();
		new Tarea().start();
		new Tarea().start();
		new Tarea().start();
		new Tarea().start();
		System.out.println("Me voy");
	}
	
	private class Tarea extends Thread {
		@Override
		public void run() {
			double plata = MultiplicoDinero.this.cuenta.extraer(100);
			System.out.println( Thread.currentThread().getName() + " Tengo " + plata + " pesos!!!!");
		}
	}
	
	public static void main(String[] args) {
		new MultiplicoDinero();
	}
}
