package bd2.model;

import java.util.Date;

/**
 * Clase Traduccion.
 * 
 * Es una clasficacion de Tarea.
 * Representa a una traduccion de un parrafo en un idioma.
 * 
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Traduccion extends Tarea{
	
	private String texto;
	private Parrafo parrafo;
	private Idioma idioma;

	/*
	 * Constructor de 6 parametros.
	 * @param fecha 		es la fecha de la traduccion.
	 * @param descripcion	es la descripcion de la traduccion.
	 * @param completa		representa si está terminada o no la traduccion.
	 * @param texto			es el texto traducido.
	 * @param idioma		es el idioma de la traduccion.
	 * */
	public Traduccion (Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma) {
		super(fecha, descripcion, completa);
		this.texto = texto;
		this.parrafo = parrafo;
		this.idioma = idioma;
	}

	/*
	 * Getter idioma.
	 * @return retorna el idioma de la traduccion.
	 * */
	public Idioma getIdioma() {
		return idioma;
	}
	
	/*
	 * Setter idioma.
	 * @param idioma de la traduccion.
	 * */
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	/*
	 * Getter parrafo.
	 * @return retorna el parrafo de la traduccion.
	 * */
	public Parrafo getParrafo() {
		return parrafo;
	}
	
	/*
	 * Metodo para obtener el idioma original que es traducido en la traduccion.
	 * @return idioma original del parrafo traducido.
	 * */
	public Idioma getIdiomaOriginal(){
		return this.getParrafo().getDocumento().getIdioma();
	}
	
	
	/*
	 * Getter texto
	 * @return retorna el texto traducido.
	 * */
	public String getTexto() {
		return this.texto;
	}
	
}
