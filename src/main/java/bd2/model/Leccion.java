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
	
	private Long id;
	private String nombre;
	
	public Leccion() {
		super();
	}
	/**
     * Constructor con 1 parametro
     * @param nombre recibe un nombre para la leccion
     */
	public Leccion(String nombre) {
		super();
		this.setNombre(nombre);
	}
	/**
	 * Getter Nombre del Diccionario
	 * @return nombre del diccionario
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
