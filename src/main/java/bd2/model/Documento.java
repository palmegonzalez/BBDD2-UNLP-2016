package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase Documento
 *
 * Representa un documento
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Documento {
	
	private Long id;
	private String nombre;
	private Integer complejidad;
	private Idioma idioma;
	private Collection<Parrafo> parrafos;
	
	public Documento() {
		super();
	}
	/**
     * Constructor con 2 parametros
     * @param nombre del documento
     * @param idioma de origen del documento
     */
	public Documento(String nombre, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.idioma = idioma;
		this.parrafos = new ArrayList<Parrafo>();
	}
	/**
	 * Getter idioma del documento
	 * @return idioma del documento
	 */
	public Idioma getIdioma() {
		return idioma;
	}
	/**
	 * Setter idioma del documento
	 * @param idioma del documento
	 */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	/**
	 * Getter nombre del documento
	 * @return nombre del documento
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter nombre del documento
	 * @param nombre del documento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Getter collection de parrafos del documento
	 * @return collection de parrafos del documento
	 */
	public Collection<Parrafo> getParrafos() {
		return parrafos;
	}
	/**
	 * agregarParrafo - crea un parrafo con el string recibido y 
	 * lo guarda en la collection de parrafos del documento
	 * @param parrafo recibe un string para crear el parrafo y agregarlo al documento
	 * @return parrafo creado y agregado a la collection de parrafos del documento
	 */
	public Parrafo agregarParrafo(String parrafo) {
		Parrafo p = new Parrafo(parrafo, this);
		this.getParrafos().add(p);
		return p;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(Integer complejidad) {
		this.complejidad = complejidad;
	}
	
}
