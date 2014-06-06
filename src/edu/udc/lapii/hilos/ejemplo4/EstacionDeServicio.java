package edu.udc.lapii.hilos.ejemplo4;

public class EstacionDeServicio {
	
	private static EstacionDeServicio instancia = new EstacionDeServicio();
	
	private double capacidadCisterna = 5000;
	private double litrosEnCisterna  = 500;
	
	public static EstacionDeServicio getEstacionDeServicio () {
		return EstacionDeServicio.instancia;
	}
	
	private EstacionDeServicio() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void llenarTanque (Vehiculo v) {
		System.out.println(v + " entra a cargar nafta");
		double cantidadNecesaria = v.getCapacidadTanque() - v.getLitrosEnTanque();
		
		if (this.litrosEnCisterna < cantidadNecesaria) {
			System.out.println("NO NAFTA para " + v + " me quedan " +  this.litrosEnCisterna + " y necesita " +cantidadNecesaria );
		}
		
		while (this.litrosEnCisterna < cantidadNecesaria) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.litrosEnCisterna -= cantidadNecesaria;
		System.out.println("Ya cargo " + v + " me quedan " +  this.litrosEnCisterna);
		v.setLitrosEnTanque(v.getLitrosEnTanque() + cantidadNecesaria);
	}
	
	public synchronized void reabastecer (CamionCisterna c) {
		this.litrosEnCisterna += c.descargar();
		System.out.println("Fin reabastecimiento hay " +  this.litrosEnCisterna);
		this.notifyAll();
	}
	
}
