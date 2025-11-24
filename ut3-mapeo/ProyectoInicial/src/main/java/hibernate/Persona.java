package hibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {
	// definir clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// revisar tipos de datos de la bbdd
	private long id;
	private String nombre;
	private int edad;
	
	public Persona() {}
	

	public Persona(String nombre, int edad) {
		super();
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
	
	

}
