package bd2.model;

import java.util.Collection;
import java.util.HashSet;

public class Curso {

	public Curso(String nombre, Idioma idioma, Integer nivel) {
		super();
		this.nombre = nombre;
		this.nivel = nivel;
		this.idioma = idioma;
		this.lecciones = new HashSet<Leccion>();
	}

	private String nombre;
	private Integer nivel;
	private Idioma idioma;
	private Collection<Leccion> lecciones;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	public Idioma getIdioma() {
		return idioma;
	}
	
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public Collection<Leccion> getLecciones() {
		return lecciones;
	}
	
	public void agregarLeccion(Leccion leccion) {
		this.getLecciones().add(leccion);
	}
	
}
