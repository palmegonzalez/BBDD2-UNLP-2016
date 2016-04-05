package bd2.model;

import java.util.Collection;

public class Sitio {

	private Collection<Documento> documentos;
	private Collection<Usuario> usuarios;
	private Collection<Curso> cursos;
	
	public Collection<Documento> getDocumentos() {
		return documentos;
	}
	
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Collection<Curso> getCursos() {
		return cursos;
	}
	
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	public void agregarCurso(Curso curso) {
		this.getCursos().add(curso);
	}
	
	public void agregarDocumento(Documento documento) {
		this.getDocumentos().add(documento);
	}

}
