package edu.udc.lapii.hilos.ejemplo3;

public class Elemento {
	private static int nextValor = 1;
	private int valor;
	
	public Elemento() {
		this.valor = Elemento.nextValor++;
	}
	
	public int getValor() {
		return valor;
	}
}
