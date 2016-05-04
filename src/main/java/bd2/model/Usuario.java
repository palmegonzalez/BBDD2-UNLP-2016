package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Clase Usuario
 *
 * Representa a un usuario
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */

public class Usuario {

	public Long id;
	public String email;
	public String nombre;
	public Date fechaDeCreacion;
	public Collection<Traduccion> traducciones;
	public Collection<Cursada> cursadasRealizadas;

	public Usuario() {
		super();
	}
	/*
	 * Constructor con 3 parámetros
	 * @param email				es el email del usuario.
	 * @param nombre			es el nombre del usuario. 
	 * @param fechaDeCreacion	es la fecha en la cual se crea el usuario.
	 * @return Usuario.
	 * */
	public Usuario(String email, String nombre, Date fechaDeCreacion) {
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
		this.traducciones = new ArrayList<Traduccion>();
		this.cursadasRealizadas = new ArrayList<Cursada>();
	}

	/*
	 * Agrega cursada a curzadas realizadas por el usuario.
	 * @param	cursada		Una cursada que realizo el usuario.
	 * */
	public void agregarCursada(Cursada cursada) {
		this.cursadasRealizadas.add(cursada);
	}

	/*
	 * Agregar una traducción realizada por el usuario.
	 * @param	traduccion		Una traduccion que realizo el usuario.
	 * */	
	public void agregarTraduccion(Traduccion traduccion) {
		this.traducciones.add(traduccion);
	}

	/*
	 * Getter Coleccion de Cursadas.
	 * @return coleccion que contiene las cursadas realizadas por el usuario.
	 * */
	public Collection<Cursada> getCursadasRealizadas() {
		return this.cursadasRealizadas;
	}

	/* Getter Coleccion de Traducciones.
	 * @return coleccion que contiene las traducciones realizadas por el usuario.
	 * */	
	public Collection<Traduccion> getTraducciones() {
		return this.traducciones;
	}

	/*
	 * Retorna el nivel máximo entre las cursadas aprobadas por	el usuario del Idioma 
	 * recibido por parámetro.
	 * @param idioma	indica el idioma para el cual obtener el nivel del usuario
	 * 					en dicho idioma.
	 * @return			Retorna el nivel máximo entre las cursadas aprobadas por el usuario
	 * */
	public int nivel(Idioma idioma) {
		int maxNivel = 0;
		for (Cursada c : this.cursadasAprobadas(idioma)) {
			if (c.getNivel() > maxNivel) {
				maxNivel = c.getNivel();
			}
		}
		return maxNivel;
	}

	/*
	 * Este metódo devuelve las cursadas aprobadas del idioma que 
	 * que se recibe como parametro por el usuario.
	 * @param idioma 	indica para que idioma obtener las cursadas aprobadas.
	 * @return coleccion de cursadas aprobadas para el idioma que se recibe. 
	 * */
	public Collection<Cursada> cursadasAprobadas(Idioma idioma) {
		
		Iterator<Cursada> i = this.getCursadasRealizadas().iterator();
		Collection<Cursada> aprobadas = new ArrayList<Cursada>();
		while (i.hasNext()){
			Cursada cursada = i.next();
			if (cursada.getCurso().getIdioma() == idioma && cursada.finalizada()){
				aprobadas.add(cursada);
			}
		}

		return aprobadas;
	}

	/*
	 * Getter email.
	 * @return retorna el email del usuario.
	 * */
	public String getEmail() {
		return this.email;
	}

	/*
	 * Getter fecha de creación.
	 * @return retorna la fecha de creación del usuario.
	 * */
	public Date getFechaDeCreacion() {
		return this.fechaDeCreacion;
	}

	/*
	 * Getter nombre
	 * @return retorna el nombre del usuario.
	 * */
	public String getNombre() {
		return this.nombre;
	}
}