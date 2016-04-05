package bd2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class Usuario {

	public String email;
	public String nombre;
	public Date fechaDeCreacion;
	public Collection<Traduccion> traducciones;
	public Collection<Cursada> cursadasRealizadas;
	
	public Usuario(String email, String nombre, Date fechaDeCreacion) {
		
		super();
		this.email = email;
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
		this.traducciones = new ArrayList<Traduccion>();
		this.cursadasRealizadas = new ArrayList<Cursada>();
	}
	
	public void agregarCursada(Cursada cursada) {
		this.cursadasRealizadas.add(cursada);
	}
	
	public void agregarTraduccion(Traduccion traduccion) {
		this.traducciones.add(traduccion);
	}
	
	public Collection<Cursada> getCursadasRealizadas() {
		return this.cursadasRealizadas;
	}
	
	public Collection<Traduccion> getTraducciones() {
		return this.traducciones;
	}
	
	public int nivel(Idioma idioma) {
		
		int maxNivel = 0;
		for (Cursada c : this.cursadasAprobadas(idioma)) {
			if (c.getNivel() > maxNivel) {
				maxNivel = c.getNivel();
			}
		}
		return maxNivel;
	}
	
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
	
	public String getEmail() {
		return this.email;
	}
	
	public Date getFechaDeCreacion() {
		return this.fechaDeCreacion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
}
