package bd2.model;

/**
 * Clase Parrafo
 *
 * Representa un parrafo de un documento.
 *
 * @author González Ezequiel - Vacca Ignacio
 * @version 1.0
 */
public class Parrafo {
	
	private Long id;
	private String texto;
	private Documento documento;
	
	public Parrafo() {
		super();
	}

	/*
	 * Constructor de 2 parametros.
	 * @param texto		es el texto del parrafo.
	 * @param documento	es el documento al cuál pertenece el parrafo. 
	 * */
	public Parrafo(String texto, Documento documento) {
		super();
		this.texto = texto;
		this.documento = documento;
	}

	/*
	 * Setter texto.
	 * @return retorna el texto del parrafo.
	 * */
	public String getTexto() {
		return texto;
	}
	
	/*
	 * Setter texto.
	 * @param settea el texto al parrafo.
	 * */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	/*
	 * Getter Documento
	 * @return Documento al cual pertenece el parrafo.
	 * */
	public Documento getDocumento() {
		return documento;
	}
	
	/*
	 * Setter Documento
	 * @param settea el documento del parrafo.
	 * */
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
