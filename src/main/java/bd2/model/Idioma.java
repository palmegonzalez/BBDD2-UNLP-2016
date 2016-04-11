package bd2.model;

/**
 * Clase idioma
 *
 * Representa un idioma
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Idioma {

	private String nombre;
	private Diccionario diccionario;

	/**
     * Constructor con 1 parametro
     * Este constructor crea un idioma con nombre recibido por parametro y un diccionario inicial vacio.
     * @param nombre del idioma
     */
	public Idioma(String nombre) {
		super();
		this.nombre = nombre;
		this.diccionario = new Diccionario(this, "Edicion Inicial");
	}
	/**
	 * Getter nombre del idioma
	 * @return nombre del idioma
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter nombre del idioma
	 * @param nombre del idioma
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Getter diccionario del idioma
	 * @return diccionario asignado al idioma
	 */
	public Diccionario getDiccionario() {
		return diccionario;
	}
	/**
	 * Setter diccionario del idioma
	 * @param diccionario asignado al idioma
	 */
	public void setDiccionario(Diccionario diccionario) {
		this.diccionario = diccionario;
	}
}
