package bd2.model;

import java.util.Collection;

/*
 * Clase Sitio
 * 
 * Representa a la aplicacion colaborativa para el aprendizaje de idiomas.
 * Los usuarios pueden tomar cursos de diversos idiomas. Para aprobar un curso
 * en particular, el usuario debe haber aprobado todas las lecciones correspondientes
 * a dicho curso. Además, los usuarios a su vez pueden ayudar a la traducción de 
 * pequeños extractos de documentos (párrafos) de un idioma a otro.
 * Las traducciones realizadas por los usuarios son revisadas por moderadores que califican dicha
 * traducción con un puntaje determinado.
 * */
public class Sitio {

	private Collection<Documento> documentos;
	private Collection<Usuario> usuarios;
	private Collection<Curso> cursos;
	
	/*
	 * Getter Documentos.
	 * @return coleccion de documentos del sitio.
	 * */
	public Collection<Documento> getDocumentos() {
		return documentos;
	}
	
	/*
	 * Getter Usuarios.
	 * @return coleccion de usuarios del sitio.
	 * */
	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}
	
	/*
	 * Getter Cursos.
	 * @return coleccion de cursos del sitio.
	 * */
	public Collection<Curso> getCursos() {
		return cursos;
	}
	
	/*
	 * Metodo para registrar un nuevo usuario en el sitio.
	 * @param usuario que se va a registrar.
	 * */
	public void registrarUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	/*
	 * Metodo para agregar un nuevo curso en el sitio.
	 * @param curso que se va a agregar.
	 * */
	public void agregarCurso(Curso curso) {
		this.getCursos().add(curso);
	}
	
	/*
	 * Metodo para agregar un nuevo documento en el sitio.
	 * @param documento que se va a agregar.
	 * */
	public void agregarDocumento(Documento documento) {
		this.getDocumentos().add(documento);
	}

}
