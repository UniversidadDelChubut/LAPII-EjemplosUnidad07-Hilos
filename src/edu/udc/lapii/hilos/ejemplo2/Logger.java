package edu.udc.lapii.hilos.ejemplo2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Logger {
	
	public static Writer writer;
	
	static {
		try {
			Logger.writer = new FileWriter("logs.txt", true);
		} catch (Exception ex){
			System.err.println("No se pudo incializar el logger");
			System.exit(1);
		}
	}
	
	public static void loggear(String mensaje){
		try {
			Logger.writer.write(mensaje);
			Logger.writer.write("\n");
			Logger.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

