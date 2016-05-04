package bd2.model;

import java.util.Collection;
import java.util.HashSet;

/**
 * Clase Curso
 *
 * Representa a un curso 
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Curso {
	
	private Long id;
	private String nombre;
	private Integer nivel;
	private Idioma idioma;
	private Collection<Leccion> lecciones;
	
	public Curso() {
		super();
	}
	/**
     * Constructor con 3 parametros
     * @param nombre del curso
     * @param idioma del curso
     * @param nivel del curso
     */
	public Curso(String nombre, Idioma idioma, Integer nivel) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.idioma = idioma;
		this.lecciones = new HashSet<Leccion>();
	}
	/**
	 * Getter nombre del curso
	 * @return nombre del curso
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter nombre del curso
	 * @param nombre del curso
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Getter nivel
	 * @return nivel del curso
	 */
	public Integer getNivel() {
		return nivel;
	}
	/**
	 * Setter nivel del curso
	 * @param nivel del curso
	 */
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	/**
	 * Getter idioma
	 * @return idioma del curso
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	/**
	 * Setter idioma del curso
	 * @param idioma del curso
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	/**
	 * Getter collection de lecciones
	 * @return collection de las lecciones del curso
	 */
	public Collection<Leccion> getLecciones() {
		return lecciones;
	}
	/**
	 * AgregarLeccion
	 * @param leccion que se agregara a la collection de lecciones del curso
	 */
	public void agregarLeccion(Leccion leccion) {
		this.getLecciones().add(leccion);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
