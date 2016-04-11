package bd2.model;

/**
 * Clase leccion
 *
 * Representa un leccion
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Leccion {
	
	private String nombre;
	
	/**
     * Constructor con 1 parametro
     * @param nombre de la leccion
     */
	public Leccion(String nombre) {
		super();
		this.setNombre(nombre);
	}
	/**
	 * Getter nombre de la leccion
	 * @return nombre de la leccion
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Setter nombre de la leccion
	 * @param nombre de la leccion
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
