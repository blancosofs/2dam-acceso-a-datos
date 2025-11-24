package correccionFrutas;

import java.util.ArrayList;

public class Fruta {
	String nombre;
	String tipo;
	String color;
	String origen;
	double precio;
	String temporada;
	ArrayList<String> nutrientes;
	
	public Fruta(String nombre, String tipo, String color, String origen, double precio, String temporada) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.color = color;
		this.origen = origen;
		this.precio = precio;
		this.temporada = temporada;
		this.nutrientes=null;
	}

	public synchronized String getNombre() {
		return nombre;
	}

	public synchronized void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public synchronized String getTipo() {
		return tipo;
	}

	public synchronized void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public synchronized String getColor() {
		return color;
	}

	public synchronized void setColor(String color) {
		this.color = color;
	}

	public synchronized String getOrigen() {
		return origen;
	}

	public synchronized void setOrigen(String origen) {
		this.origen = origen;
	}

	public synchronized double getPrecio() {
		return precio;
	}

	public synchronized void setPrecio(double precio) {
		this.precio = precio;
	}

	public synchronized String getTemporada() {
		return temporada;
	}

	public synchronized void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public synchronized ArrayList<String> getNutrientes() {
		return nutrientes;
	}

	public synchronized void setNutrientes(ArrayList<String> nutrientes) {
		this.nutrientes = nutrientes;
	}

	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", tipo=" + tipo + ", color=" + color + ", origen=" + origen + ", precio="
				+ precio + ", temporada=" + temporada + "]";
	}
	
	
 
}
