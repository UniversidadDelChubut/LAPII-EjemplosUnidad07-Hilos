package edu.udc.lapii.hilos.ejemplo4;

import java.util.Random;

public class Taxi extends Vehiculo implements Runnable {
	
	Random rnd = new Random();
	
	private String nombre;
	
	private int minutosPromedioEntreViajes = 40;
	private int kilometrosPromedioPorViaje = 15;
	
	public Taxi(String nombre) {
		this.nombre = nombre;
		this.capacidadTanque    = 50    ;  
		this.litrosEnTanque     = 50.0  ;
		this.kilometrosPorLitro = 10.0  ;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	private void hacerViaje() {
		int tiempoEspera = (int) (
				this.minutosPromedioEntreViajes + 
				(rnd.nextBoolean()  ? 1 : -1) *
				rnd.nextDouble() * this.minutosPromedioEntreViajes)
				;
				
		int kilometrosARecorrer = (int) (
				this.kilometrosPromedioPorViaje +
				(rnd.nextBoolean()  ? 1 : -1) *
				(rnd.nextDouble() / 2)  * 
				this.kilometrosPromedioPorViaje);
		
		try {
			Thread.sleep(tiempoEspera * 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		double consumo = kilometrosARecorrer / this.kilometrosPorLitro;
		
		if (consumo > this.litrosEnTanque) {
			litrosEnTanque = 0;
		} else {
			litrosEnTanque -= consumo;
		}
	}
	
	@Override
	public void run() {
		for (;;) {
			System.out.println(this + " hara viaje");
			this.hacerViaje();
			System.out.println("a " + this + " le quedan " + this.litrosEnTanque);
			if (this.litrosEnTanque <= 5){
				System.out.println("a " + this + " le toca cargar");
				EstacionDeServicio.getEstacionDeServicio().llenarTanque(this);
			}
		}
	}
	
}
