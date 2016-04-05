package bd2.model;

import java.util.Date;

public class Tarea {
	
	public Date fecha;
	public String descripcion;
	public Boolean completa;
	
	public Tarea(Date fecha, String descripcion, Boolean completa) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completa = completa;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void completar() {
		this.completa = true;
	}
	
	public boolean getCompleta() {
		return this.completa;
	}

}
