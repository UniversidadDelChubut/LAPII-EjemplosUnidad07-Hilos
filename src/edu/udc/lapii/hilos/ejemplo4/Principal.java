package edu.udc.lapii.hilos.ejemplo4;

public class Principal {
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 20 ; i++ ){
			new Thread (new Taxi("Taxi" + i)).start();
		}
		
		new Logistica().start();
	}
}

class Logistica extends Thread {
	@Override
	public void run() {
		for (;;){
			try {
				Thread.sleep(12 * 1000) ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CamionCisterna c= new CamionCisterna(2500);
			System.out.println("MANDO CAMION!!!!!");
			EstacionDeServicio.getEstacionDeServicio().reabastecer(c);
		}
	}
}
