package edu.udc.lapii.hilos.ejemplo5;

import java.util.Random;

public class RocaPapelOTijera {

	public static String ROCA =   "Roca  ";
	public static String PAPEL =  "Papel ";
	public static String TIJERA = "Tijera";
	
	Jugador jugador1 = new Jugador();
	Jugador jugador2 = new Jugador();

	int puntosJugador1 = 0;
	int puntosJugador2 = 0;
	
	public void jugar() {
		
		int cantidadJugadas = 3;
		
		
		long inicio = System.currentTimeMillis();
		
		
		int i = 0;
		while (i < cantidadJugadas) {
			
			Thread h1 = new Thread(jugador1);
			Thread h2 = new Thread(jugador2);
			h1.start();
			h2.start();
			
			try {
				h1.join();
				h2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(jugador1.getJugada() + "  " + jugador2.getJugada() + " ");
			int comparacion =  compararJugadas(jugador1.getJugada(), jugador2.getJugada());
			i++;
			if (comparacion == -1) ganaManoJugador(jugador1);
			if (comparacion ==  1) ganaManoJugador(jugador2);
			if (comparacion ==  0) {
				ganaManoJugador(null); 
				i--;
			}
			
			
		}
		
		System.out.println("Todo OK");
		System.out.println("Tiempo total de ejecucion: " + (System.currentTimeMillis() - inicio) + " milisegundos");
		
	}
	
	void ganaManoJugador(Jugador jugador) {
		if (jugador == null){
			System.out.println(" EMPATE");
			return;			
		}
		if (jugador.equals(jugador1)) { 
			puntosJugador1++;
			System.out.println(" PUNTO PARA JUGADOR 1 ");
		} else { 
			puntosJugador2++;
			System.out.println(" PUNTO PARA JUGADOR 2 ");
		}
		
	}
	
	public int compararJugadas(String jugada1, String jugada2) {
		if (jugada1.equals(jugada2)){
			return 0;
		}
		if (jugada1.equals(ROCA)  && jugada2.equals(TIJERA)) return -1;
		if (jugada1.equals(TIJERA) && jugada2.equals(PAPEL)) return -1;
		if (jugada1.equals(PAPEL)  && jugada2.equals(ROCA) ) return -1;
		
		return 1;
	}
	
	public static void main(String[] args) {
		new RocaPapelOTijera().jugar();
	}
}



class Jugador implements Runnable  {
	
	private Random random = new Random();
	private String jugada;
	
	public Jugador() {
		
	}
	
	public String getJugada() {
		return jugada;
	}
	
	public void run() {
		int val = random.nextInt(3);
		switch (val) {
			case 0: this.jugada = RocaPapelOTijera.ROCA;   break;
			case 1: this.jugada = RocaPapelOTijera.PAPEL;  break;
			case 2: this.jugada = RocaPapelOTijera.TIJERA; break;
		}
	}
	
	
}
