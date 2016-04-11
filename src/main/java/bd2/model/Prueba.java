package bd2.model;

/*
 * Clase Prueba
 * 
 * Representa una prueba.
 * 
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 * */
public class Prueba {
	
	private Integer puntaje;
	private Leccion leccion;

	/*
	 * Constructor con 2 parametros.
	 * @param leccion	leccion de la prueba.
	 * @param puntaje	puntaje de la prueba.
	 * @return Prueba.
	 * */
	public Prueba(Leccion leccion, Integer puntaje) throws Exception {
		this.setLeccion(leccion);
		this.setPuntaje(puntaje);
	}

	/*
	 * Getter puntaje.
	 * @return puntaje de la prueba.
	 * */
	public int getPuntaje() {
		return puntaje;
	}
	
	/*
	 * Setter Puntaje.
	 * @param puntaje a settear en la prueba.
	 * @throws Exception si puntaje es menor a 0.
	 * @throws Exception si puntaje es mayor a 100.
	 * */
	public void setPuntaje(Integer puntaje) throws Exception {
		if (puntaje < 0){
			throw new Exception("No se puede usar valores negativos como puntaje de una prueba.");
		}else if (puntaje > 100) {
			throw new Exception("No se puede usar valores mayores a 100 como puntaje de una prueba.");
		}
		
		this.puntaje = puntaje;
	}
	
	/*
	 * Getter Leccion.
	 * @return leccion de la prueba. 
	 * */
	public Leccion getLeccion() {
		return leccion;
	}
	
	/*
	 * Setter Leccion.
	 * @param leccion leccion de la prueba.
	 * */
	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}

	/*
	 * Metodo para saber si la prueba está aprobada.
	 * @return boolean true si puntaje >=60.
	 * */
	public Boolean aprobada() {
		return (this.getPuntaje() >= 60 );
	}

}
