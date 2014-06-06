package edu.udc.lapii.hilos.ejemplo1;

public class Principal {
	public static void main(String[] args) {
		new PingPong("ping", 1000).start();
		new PingPong("PONG", 2500).start();
	}
}
