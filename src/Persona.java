import java.util.Collection;
import java.util.LinkedList;

public class Persona {
	
	private String nombre;
	private String apellido;
	private int edad;
			
	public String getNombre() {
		return nombre;
	}
	public Persona setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}
	public String getApellido() {
		return apellido;
	}
	public Persona setApellido(String apellido) {
		this.apellido = apellido;
		return this;
	}
	public int getEdad() {
		return edad;
	}
	public Persona setEdad(int edad) {
		this.edad = edad;
		return this;
	}

	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Collection<Persona> personas = new LinkedList<Persona>();
		personas.add(new Persona().setNombre("luis").setApellido("gomez").setEdad(13));
	}
	
}
