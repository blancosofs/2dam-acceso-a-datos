package ejercicioNBA;

public class Jugador {
	int vjCodigo ;
	String vjNombre;
	String vjProcedencia;
	String vjAltura;
	int vjPeso;
	String vjPosicion ;
	String vjNombre_equipo ;
	
	public Jugador() {}
	
	public Jugador(int vjCodigo, String vjNombre, String vjProcedencia, String vjAltura, int vjPeso, String vjPosicion,
			String vjNombre_equipo) {
		super();
		this.vjCodigo = vjCodigo;
		this.vjNombre = vjNombre;
		this.vjProcedencia = vjProcedencia;
		this.vjAltura = vjAltura;
		this.vjPeso = vjPeso;
		this.vjPosicion = vjPosicion;
		this.vjNombre_equipo = vjNombre_equipo;
	}
	public synchronized int getVjCodigo() {
		return vjCodigo;
	}
	public synchronized void setVjCodigo(int vjCodigo) {
		this.vjCodigo = vjCodigo;
	}
	public synchronized String getVjNombre() {
		return vjNombre;
	}
	public synchronized void setVjNombre(String vjNombre) {
		this.vjNombre = vjNombre;
	}
	public synchronized String getVjProcedencia() {
		return vjProcedencia;
	}
	public synchronized void setVjProcedencia(String vjProcedencia) {
		this.vjProcedencia = vjProcedencia;
	}
	public synchronized String getVjAltura() {
		return vjAltura;
	}
	public synchronized void setVjAltura(String vjAltura) {
		this.vjAltura = vjAltura;
	}
	public synchronized int getVjPeso() {
		return vjPeso;
	}
	public synchronized void setVjPeso(int vjPeso) {
		this.vjPeso = vjPeso;
	}
	public synchronized String getVjPosicion() {
		return vjPosicion;
	}
	public synchronized void setVjPosicion(String vjPosicion) {
		this.vjPosicion = vjPosicion;
	}
	public synchronized String getVjNombre_equipo() {
		return vjNombre_equipo;
	}
	public synchronized void setVjNombre_equipo(String vjNombre_equipo) {
		this.vjNombre_equipo = vjNombre_equipo;
	}

	@Override
	public String toString() {
		return "Jugador [vjCodigo=" + vjCodigo + ", vjNombre=" + vjNombre + ", vjProcedencia=" + vjProcedencia
				+ ", vjAltura=" + vjAltura + ", vjPeso=" + vjPeso + ", vjPosicion=" + vjPosicion + ", vjNombre_equipo="
				+ vjNombre_equipo + "]";
	}
	
	
}
