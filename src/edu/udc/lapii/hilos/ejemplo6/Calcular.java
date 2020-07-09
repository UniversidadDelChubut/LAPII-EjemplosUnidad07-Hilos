package edu.udc.lapii.hilos.ejemplo6;

import java.math.BigInteger;

public class Calcular {
	public static void main(String[] args) {
		unFactorial(8);
		
		int[] enes = {8, 9, 15, 12};
		variosFactoriales(enes);
	}

	public static void unFactorial(int n) {
		try {
			
			Factorial f = new Factorial(n);
			f.start();
			f.join();
			System.out.println(f.getValor());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	
	
	public static void variosFactoriales(int [] enes) {
		try {
			
			BigInteger suma = BigInteger.ZERO;
			
			Factorial [] factoriales = new Factorial[enes.length];
			int i = 0;
			for (int n: enes) {
				factoriales[i] = new Factorial(enes[i]);
				factoriales[i].start();
				i++;
			}
			
			
			for (Factorial f: factoriales) {
				f.join();
				suma = suma.add(f.getValor());
			}
			
			
			System.out.println(suma);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}


class Factorial extends Thread {
	
	private int n;
	private BigInteger valor;
	
	public Factorial(int n) {
		this.n = n;
	}
	 
	@Override
	public void run() {
		this.valor = BigInteger.ONE;
		for (int i = 1; i<= n; i++) {
			this.valor = this.valor.multiply(BigInteger.valueOf(i));
		}
	}
	
	
	public BigInteger getValor() {
		return valor;
	}
	
}