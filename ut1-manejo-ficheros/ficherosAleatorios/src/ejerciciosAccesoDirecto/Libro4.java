package ejerciciosAccesoDirecto;

public class Libro4 {
	String titulo;
	String autor;
	double precio;

	public Libro4() {
	}

	public Libro4(String titulo, String autor, double precio) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro4 [titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + "]";
	}

}
