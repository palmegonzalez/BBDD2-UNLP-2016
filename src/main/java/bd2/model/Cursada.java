package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class Cursada {

	Date inicio;
	Usuario usuario;
	Collection<Prueba> pruebas; 
	Curso curso;

	public Cursada(Curso curso, Date inicio, Usuario usuario) {
		super();
		this.inicio = inicio;
		this.usuario = usuario;
		this.curso = curso;
		this.pruebas = new ArrayList<Prueba>();
		usuario.agregarCursada(this);
	}
	
	public Date getInicio() {
		return inicio;
	}
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public Collection<Prueba> getPruebas() {
		return pruebas;
	}
	
	public Idioma getIdioma() {
		return this.getCurso().getIdioma();
	}
	
	public void agregarPrueba(Prueba prueba) {
		this.getPruebas().add(prueba);
	}
		
	public Boolean finalizada() {
		for (Leccion leccion : this.getCurso().getLecciones()) {
			if (!this.leccionesAprobadas().contains(leccion)) {
				return false;
			}
		}
		return true;
	}
	
	public Integer getNivel() {
		return this.getCurso().getNivel();
	}
	
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
}
