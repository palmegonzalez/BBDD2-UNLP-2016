package bd2.model;

import java.util.Date;

public class Evaluacion extends Tarea {

	private Integer puntaje;
	private Traduccion traduccion;

	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, Integer puntaje) {
		super(fecha, descripcion, completa);
		this.puntaje = puntaje;
		this.traduccion = traduccion;	
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
	
	public Traduccion getTraduccion() {
		return traduccion;
	}
	
	public void setTraduccion(Traduccion traduccion) {
		this.traduccion = traduccion;
	}
	
}
