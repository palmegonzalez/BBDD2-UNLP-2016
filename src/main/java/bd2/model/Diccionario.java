package bd2.model;

import java.util.HashMap;
import java.util.Map;

public class Diccionario {

	private Map<String, String> definiciones;
	private String edicion;
	private Idioma idioma;

	public Diccionario(Idioma idioma, String edicion) {
		super();
		this.edicion = edicion;
		this.idioma = idioma;
		this.definiciones = new HashMap<String, String>();
		idioma.setDiccionario(this);
	}
	
	public String getEdicion() {
		return edicion;
	}
	
	public void setEdicion(String edicion) {
		this.edicion = edicion;
	}
	
	public Idioma getIdioma() {
		return this.idioma;
	}
	
	public String definicion(String clave){
		return this.getDefiniciones().get(clave);
	}
	
	public void agregarDefinicion(String clave, String valor) {
		this.getDefiniciones().put(clave, valor);
	}
	
	public Map<String,String>  getDefiniciones() {
		return this.definiciones;	
	}

}
