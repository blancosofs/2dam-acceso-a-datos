package ejemplo;

import java.io.Serializable;

public class Persona implements Serializable{ //se puede transformar en un flujo de datos. Escribir siempre
	//El objeto este luego lo quieres en un flujo de bytes ynecesitas ese implements Serializable
	
	private String nombre;
	private int edad;
	
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
	

}
