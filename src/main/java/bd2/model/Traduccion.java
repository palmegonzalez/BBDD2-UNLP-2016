package bd2.model;

import java.util.Date;

public class Traduccion extends Tarea{
	
	private String texto;
	private Parrafo parrafo;
	private Idioma idioma;
	
	public Traduccion (Date fecha, String descripcion, Boolean completa, String texto, Parrafo parrafo, Idioma idioma) {
		super(fecha, descripcion, completa);
		this.texto = texto;
		this.parrafo = parrafo;
		this.idioma = idioma;
	}

	public Idioma getIdioma() {
		return idioma;
	}
	
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public Parrafo getParrafo() {
		return parrafo;
	}
	
	public Idioma getIdiomaOriginal(){
		return this.getParrafo().getDocumento().getIdioma();
	}
	
	public String getTexto() {
		return this.texto;
	}
	
}
