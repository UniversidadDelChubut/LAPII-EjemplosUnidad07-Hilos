package edu.udc.lapii.hilos.ejemplo4;

public abstract class Vehiculo {
	protected double kilometrosPorLitro;
	protected int capacidadTanque;
	protected double litrosEnTanque;
	
	public double getLitrosEnTanque() {
		return litrosEnTanque;
	}
	
	protected void setLitrosEnTanque(double litrosEnTanque) {
		this.litrosEnTanque = litrosEnTanque;
	}
	
	public double getKilometrosPorLitro() {
		return kilometrosPorLitro;
	}
	
	public int getCapacidadTanque() {
		return capacidadTanque;
	}

	
}
