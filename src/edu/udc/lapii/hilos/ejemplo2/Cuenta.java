package edu.udc.lapii.hilos.ejemplo2;

import java.util.Date;

public class Cuenta {
	
	private int numero;
	protected double saldo;
	
	public Cuenta(int numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	public synchronized double getSaldo() {
		return saldo;
	}
	
	public synchronized double extraer(double monto){
		if (this.saldo >= monto){
			Logger.loggear (new Date()+ " " + Thread.currentThread().getName() + " Se estan extrayendo " + monto + " pesos de la cuenta numero " + this.numero);
			this.saldo -= monto;
			return monto;
		}
		return 0;
	}
	
	public int getNumero() {
		return numero;
	}
	
	
	public void hacerTareaLarga(){
		//UN monton de cosas
		
		synchronized (this) {
			
		}
		
		//Otro monton de cosas
	}
}
