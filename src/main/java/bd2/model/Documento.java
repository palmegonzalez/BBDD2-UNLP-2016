package bd2.model;

import java.util.ArrayList;
import java.util.Collection;

public class Documento {
	
	private String nombre;
	private Integer complejidad;
	private Idioma idioma;
	private Collection<Parrafo> parrafos;
	
	public Documento(String nombre, Idioma idioma) {
		super();
		this.nombre = nombre;
		this.idioma = idioma;
		this.parrafos = new ArrayList<Parrafo>();
	}
	
	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Collection<Parrafo> getParrafos() {
		return parrafos;
	}

	public Parrafo agregarParrafo(String parrafo) {
		Parrafo p = new Parrafo(parrafo, this);
		this.getParrafos().add(p);
		return p;
	}
	
}
