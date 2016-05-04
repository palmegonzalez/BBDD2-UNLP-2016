package bd2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Diccionario
 *
 * Representa una edicion de un diccionario para un idioma
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Diccionario {
	
	private Long id;
	private Map<String, String> definiciones;
	private String edicion;
	private Idioma idioma;
	
	public Diccionario() {
		super();
	}
	/**
     * Constructor con 2 parametros
     * Este constructor crea un diccionario y se agrega como el diccionario actual del idioma al que pertenece
     * @param idioma del diccionario
     * @param edicion nombre de la edicion del diccionario
     */
	public Diccionario(Idioma idioma, String edicion) {
		super();
		this.edicion = edicion;
		this.idioma = idioma;
		this.definiciones = new HashMap<String, String>();
		idioma.setDiccionario(this);
	}
	/**
	 * Getter edicion del diccionario
	 * @return edicion del diccionario
	 */
	public String getEdicion() {
		return edicion;
	}
	/**
	 * Setter edicion del diccionario
	 * @param edicion del diccionario
	 */
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	/**
	 * Getter idioma del diccionario
	 * @return idioma del diccionario
	 */
	public Idioma getIdioma() {
		return this.idioma;
	}
	/**
	 * definicion - devuelve una definicion para la clave recibida
	 * @return clave de la definicion a devolver
	 */
	public String definicion(String clave){
		return this.getDefiniciones().get(clave);
	}
	/**
	 * AgregarDefinicion - agrega una definicion clave, valor al diccionario
	 * @param clave de la definicion
	 * @param valor de la definicion
	 */
	public void agregarDefinicion(String clave, String valor) {
		this.getDefiniciones().put(clave, valor);
	}
	/**
	 * Getter Map de definiciones del diccionario
	 * @return Map<String, String> de definiciones del diccionario
	 */
	public Map<String,String>  getDefiniciones() {
		return this.definiciones;	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
