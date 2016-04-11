package bd2.model;

import java.util.Date;

/**
 * Clase Tarea.
 *
 * Representa una tarea.
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Tarea {
	
	public Date fecha;
	public String descripcion;
	public Boolean completa;
	
	/*
	 * Constructor de 3 parametros.
	 * @param fecha			fecha de la tarea.
	 * @param descripcion	descripcion de la tarea.
	 * @param completa		si la tarea esta completa o no.
	 * @return Tarea.
	 * */
	public Tarea(Date fecha, String descripcion, Boolean completa) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.completa = completa;
	}

	/*
	 * Getter fecha.
	 * @return fecha de la tarea.
	 * */
	public Date getFecha() {
		return fecha;
	}
	
	/*
	 * Setter fecha
	 * @param fecha de la tarea.
	 * */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/*
	 * Getter Descripcion
	 * @return descripcion de la tarea
	 * */
	public String getDescripcion() {
		return descripcion;
	}
	
	/*
	 * Setter Descripcion
	 * @param descripcion de la tarea.
	 * */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/*
	 * Metodo que marca la tarea como completa.
	 * */
	public void completar() {
		this.completa = true;
	}
	
	/*
	 * Getter completa
	 * @return	true si la tarea esta completa.
	 * 			false si no esta completa.
	 * */
	public boolean getCompleta() {
		return this.completa;
	}

}
