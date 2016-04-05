package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Moderador extends Usuario{

	Collection<Evaluacion> evaluaciones;
	Collection<Idioma> idiomas;
	
	public Moderador(String email, String nombre, Date fechaDeCreacion) {
		super(email, nombre, fechaDeCreacion);
		this.evaluaciones = new ArrayList<Evaluacion>();
		this.idiomas = new ArrayList<Idioma>();
	}

	public void agregarIdioma(Idioma idioma) {
		this.getIdiomas().add(idioma);
	}
	
	public Collection<Idioma> getIdiomas() {
		return this.idiomas;
	}
	
	public int reputacion() {
		return this.getEvaluaciones().size();
	}
	
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception {
		
		if (this.manejaIdioma(traduccion.getIdiomaOriginal()) && this.manejaIdioma(traduccion.getIdioma())){
			Evaluacion evaluacion = new Evaluacion(new Date(), descripcion, true, traduccion, puntaje);
			this.getEvaluaciones().add(evaluacion);
		}else{
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}
	
	public Boolean manejaIdioma(Idioma idioma) {
		return this.getIdiomas().contains(idioma);
	}
	
	public Collection<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}
}
