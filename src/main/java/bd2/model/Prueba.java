package bd2.model;

public class Prueba {
	
	private Integer puntaje;
	private Leccion leccion;

	public Prueba(Leccion leccion, Integer puntaje) throws Exception {
		this.setLeccion(leccion);
		this.setPuntaje(puntaje);
	}

	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(Integer puntaje) throws Exception {
		if (puntaje < 0){
			throw new Exception("No se puede usar valores negativos como puntaje de una prueba.");
		}else if (puntaje > 100) {
			throw new Exception("No se puede usar valores mayores a 100 como puntaje de una prueba.");
		}
		
		this.puntaje = puntaje;
	}
	
	public Leccion getLeccion() {
		return leccion;
	}
	
	public void setLeccion(Leccion leccion) {
		this.leccion = leccion;
	}

	public Boolean aprobada() {
		return (this.getPuntaje() >= 60 );
	}

}
