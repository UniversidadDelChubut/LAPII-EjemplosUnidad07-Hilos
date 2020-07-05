package edu.udc.lapii.hilos.ejemplo3;

import java.util.LinkedList;
import java.util.List;

public class Productor implements Runnable {
	Buffer buffer;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for (;;){
			//this.buffer.addElemento(new Elemento());
			List<Elemento> lista = new LinkedList<Elemento>();
			for (int i =0;i<3; i++) {
				lista.add(new Elemento());
			}
			buffer.addElementos(lista);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
