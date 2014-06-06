package edu.udc.lapii.hilos.ejemplo3;

import java.util.LinkedList;
import java.util.List;

public class Buffer {
	
	private List<Elemento> lista = new LinkedList<Elemento>();
	
	public synchronized Elemento getElemento() {
		while (this.lista.size() == 0){
			System.out.println(Thread.currentThread().getName()  + " se bloquea " );
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()  + " despierto " );
		}
		return lista.remove(0);
	}
	
	public synchronized void addElemento(Elemento elemento) {
		this.lista.add(elemento);
		this.notify();
	}
	
	public synchronized void addElementos(List<Elemento> elementos) {
		this.lista.addAll(elementos);
		this.notifyAll();
	}
	
}

