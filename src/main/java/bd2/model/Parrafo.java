package bd2.model;

public class Parrafo {

	private String texto;
	private Documento documento;
	
	public Parrafo(String texto, Documento documento) {
		super();
		this.texto = texto;
		this.documento = documento;
	}

	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Documento getDocumento() {
		return documento;
	}
	
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	
}
