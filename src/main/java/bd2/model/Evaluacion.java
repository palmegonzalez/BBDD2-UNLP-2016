package bd2.model;

import java.util.Date;

/**
 * Clase Evaluacion
 *
 * Representa una evaluacion
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Evaluacion extends Tarea {

	private Integer puntaje;
	private Traduccion traduccion;

	public Evaluacion() {
		super();
	}
	/**
     * Constructor con 5 parametros
     * @param fecha en que se realizo la evaluacion
     * @param descripcion de la evaluacion
     * @param completa informa si esta completa o no la evaluacion
     * @param traduccion a la que se evalua
     * @param puntaje que resulto de la evaluacion
     */
	public Evaluacion(Date fecha, String descripcion, Boolean completa, Traduccion traduccion, Integer puntaje) {
		super(fecha, descripcion, completa);
		this.puntaje = puntaje;
		this.traduccion = traduccion;	
	}
	/**
	 * Getter puntaje de la evaluacion
	 * @return puntaje de la evaluacion
	 */
	public int getPuntaje() {
		return puntaje;
	}
	/**
	 * Setter puntaje de la evaluacion
	 * @param puntaje de la evaluacion
	 */
	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}
	/**
	 * Getter traduccion de la evaluacion
	 * @return traduccion que se esta evaluando
	 */
	public Traduccion getTraduccion() {
		return traduccion;
	}
	/**
	 * Setter traduccion de la evaluacion
	 * @param traduccion que se esta evaluando
	 */
	public void setTraduccion(Traduccion traduccion) {
		this.traduccion = traduccion;
	}
	
}
