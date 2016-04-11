package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Clase Moderador
 *
 * Representa un usuario que es moderador en el sistema.
 * Los moderadores pueden revisar las traducciones de los usuarios
 * del sistema y evaluar con un puntaje dichas traducciones.
 * Los moderadores pueden evaluar aquellas traducciones realizadas
 * en los idiomas que el moderador maneja.
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Moderador extends Usuario{

	Collection<Evaluacion> evaluaciones;
	Collection<Idioma> idiomas;

	/*
	 * Constructor de 3 parametros.
	 * @param email				email del moderador.
	 * @param nombre			nombre del moderador.
	 * @param fechaDeCreacion	fecha en la cual se crea al moderador.
	 * @return Moderador.
	 * */
	public Moderador(String email, String nombre, Date fechaDeCreacion) {
		super(email, nombre, fechaDeCreacion);
		this.evaluaciones = new ArrayList<Evaluacion>();
		this.idiomas = new ArrayList<Idioma>();
	}

	/*
	 * Metodo para agregar un idioma que maneja el moderador.
	 * @param idioma a agregar.
	 * */
	public void agregarIdioma(Idioma idioma) {
		this.getIdiomas().add(idioma);
	}
	
	/*
	 * Metodo para obtener los idiomas que maneja el moderador.
	 * @return coleccion de idiomas.
	 * */
	public Collection<Idioma> getIdiomas() {
		return this.idiomas;
	}
	
	/*
	 * Meotodo para obtener la reputacion del moderador.
	 * @return la cantidad de evaluaciones que hizo el moderador es su reputacion.
	 * */
	public int reputacion() {
		return this.getEvaluaciones().size();
	}
	
	/*
	 * Metodo para evaluar una traduccion que se recibe como parametro.
	 * Para poder evaluar el moderador debe manejar el idioma de la traduccion.
	 * @param traduccion	es la traduccion a evaluar.
	 * @param descripcion	es la descripcion de la evaluacion.
	 * @param puntaje		es el puntaje de la evaluacion.
	 * @throws Exception	si no maneja los idiomas.
	 * */
	public void evaluar(Traduccion traduccion, String descripcion, Integer puntaje) throws Exception {
		
		if (this.manejaIdioma(traduccion.getIdiomaOriginal()) && this.manejaIdioma(traduccion.getIdioma())){
			Evaluacion evaluacion = new Evaluacion(new Date(), descripcion, true, traduccion, puntaje);
			this.getEvaluaciones().add(evaluacion);
		}else{
			throw new Exception("No se pueden evaluar traducciones de idiomas que el moderador no maneja.");
		}
	}
	
	/*
	 * Metodo para saber si el moderador maneja un idioma.
	 * @param idioma a averiguar si el moderador maneja
	 * @return boolean true si el moderador maneja el idioma.
	 * */
	public Boolean manejaIdioma(Idioma idioma) {
		return this.getIdiomas().contains(idioma);
	}
	
	/*
	 * Getter Evaluaciones
	 * @return coleccion de evaluaciones del moderador.
	 * */
	public Collection<Evaluacion> getEvaluaciones() {
		return this.evaluaciones;
	}
}
