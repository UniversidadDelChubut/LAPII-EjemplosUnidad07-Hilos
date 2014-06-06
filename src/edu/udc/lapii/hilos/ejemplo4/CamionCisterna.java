package edu.udc.lapii.hilos.ejemplo4;

public class CamionCisterna {
	
	private int litrosEnCisterna;
	
	protected int descargar(){
		int litros = this.litrosEnCisterna;
		this.litrosEnCisterna = 0; 
		return litros;
	}
	
	public CamionCisterna(int litrosEnCisterna) {
		this.litrosEnCisterna = litrosEnCisterna;
	}
}
