package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Clase Cursada
 *
 * Representa a una cursada de un usuario
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Cursada {
	
	private Long id;
	private Date inicio;
	private Usuario usuario;
	private Collection<Prueba> pruebas; 
	private Curso curso;

	public Cursada() {
		super();
	}
	/**
     * Constructor con 3 parametros
     * @param curso indica el curso al que pertenece la cursada
     * @param inicio indica la fecha en que inicia la cursada
     * @param usuario indica el usuario al que pertenece la cursada
     */
	public Cursada(Curso curso, Date inicio, Usuario usuario) {
		super();
		this.inicio = inicio;
		this.usuario = usuario;
		this.curso = curso;
		this.pruebas = new ArrayList<Prueba>();
		usuario.agregarCursada(this);
	}
	/**
	 * Getter fecha de inicio
	 * @return Date con la fecha de la cursada
	 */
	public Date getInicio() {
		return inicio;
	}
	/**
	 * Setter fecha de inicio.
	 * @param inicio - fecha de inicio de la cursada
	 */
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	/**
	 * Getter Usuario.
	 * @return usuario al que pertenece la cursada
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * Setter Usuario
	 * @param usuario al que pertenece la cursada
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * Getter Curso
	 * @return curso al que pertenece la cursada
	 */
	public Curso getCurso() {
		return curso;
	}
	/**
	 * Setter Curso
	 * @param curso al que pertenece la cursada
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	/**
	 * Getter Coleccion de Pruebas
	 * @return coleccion que contiene las pruebas de la cursada
	 */
	public Collection<Prueba> getPruebas() {
		return pruebas;
	}
	/**
	 * Getter idioma
	 * @return idioma del curso al que pertenece la cursada
	 */
	public Idioma getIdioma() {
		return this.getCurso().getIdioma();
	}
	/**
	 * Agregar Prueba
	 * @param prueba que se quiere incluir a las pruebas de la cursada
	 */
	public void agregarPrueba(Prueba prueba) {
		this.getPruebas().add(prueba);
	}
	/**
	 * Finalizada
	 * @return true/false indicando si la cursada esta finalizada.	 
	 * Esto significa que existe al menos una prueba(aprobada) 
	 * para cada lección del curso correspondiente.
	 */
	public Boolean finalizada() {
		for (Leccion leccion : this.getCurso().getLecciones()) {
			if (!this.leccionesAprobadas().contains(leccion)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Getter nivel
	 * @return integer que representa el nivel del curso al que pertenece la cursada
	 */
	public Integer getNivel() {
		return this.getCurso().getNivel();
	}
	/**
	 * LeccionesAprobadas
	 * @return Collection de las lecciones aprobadas del curso al que pertenece la cursada
	 */
	public Collection<Leccion> leccionesAprobadas() {
		Iterator<Prueba> i = this.getPruebas().iterator();
		Collection<Leccion> lecciones = new ArrayList<Leccion>();
		while (i.hasNext()){
			Prueba prueba = i.next();
			if (prueba.aprobada()){
				lecciones.add(prueba.getLeccion());
			}
		}
		return lecciones;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
