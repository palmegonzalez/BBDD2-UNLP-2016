package bd2.util;


import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bd2.model.Diccionario;
import bd2.model.Documento;
import bd2.model.Moderador;
import bd2.model.Traduccion;
import bd2.model.Usuario;

/**
 * Clase Queries
 *
 * Representa las consultas a la BBDD.
 *
 * @author GRUPO 21 | González Ezequiel - Vacca Ignacio
 * @version 1.0
 */

public class Queries {
	
	private static SessionFactory sessions;

	public Queries(){}
	
	public static void main(String[] args){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		
		sessions = cfg.buildSessionFactory();
		
		a();
		b();
		c();
		d("2015-07-01", "2015-12-31");
		e();
		f();
		g("Amigo");
		h();
		i("Aleman");
	}
	
	/**
	 * Metodo A.
	 * Lista los nombres de todos los documentos
	 */
	public static void a(){
		System.out.println("A. Listar los nombres de todos los documentos. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("from Documento");

		List<Documento> documentos = query.list();
		for (Documento documento : documentos){
			System.out.println("Documento: '" + documento.getNombre() + "'.");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo B.
	 * Lista los emails de los moderadores que hayan evaluado traducciones al inglés
	 */
	public static void b(){
		System.out.println("B. Listar los emails de los moderadores que hayan evaluado traducciones al inglés. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct m from Moderador m join m.evaluaciones e join e.traduccion t where t.idioma.nombre = :nom_idioma");
		query.setParameter("nom_idioma", "ingles");
		
		List<Moderador> moderadores = query.list();
		for (Moderador moderador : moderadores){
			System.out.println("Email: " + moderador.getEmail());
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo C.
	 * Lista los usuarios que hayan iniciado una cursada de Francés de nivel 3 como minimo
	 */
	public static void c(){
		System.out.println("C. Listar los usuarios que hayan iniciado una cursada de Fránces de nivel 3 como mínimo. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct u from Usuario u join u.cursadasRealizadas c where c.curso.idioma.nombre = :nom_idioma and c.curso.nivel >= :nivel");
		query.setParameter("nom_idioma", "Frances");
		query.setParameter("nivel", 3);
		
		List<Usuario> usuarios = query.list();
		for (Usuario usuario : usuarios){
			System.out.println("Nombre: " + usuario.getNombre() + ".");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo D.
	 * Lista los moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento
	 * @param fecha_inicio se especifica la fecha desde donde comienza la busqueda
	 * @param fecha_fin se especifica la fecha hasta donde termina la busqueda
	 */
	public static void d(String fecha_inicio, String fecha_fin){
		System.out.println("D. Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct m from Moderador m join m.evaluaciones e where e.fecha between :fecha_inicio and :fecha_fin");
		query.setString("fecha_inicio", fecha_inicio);
		query.setString("fecha_fin", fecha_fin);

		List<Moderador> moderadores = query.list();
		for (Moderador moderador : moderadores){
			System.out.println("Moderador: " + moderador.getNombre() + ".");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();		
	}
	
	/**
	 * Metodo E.
	 * Lista las traducciones completas del ingles al frances
	 */
	public static void e(){
		System.out.println("E. Listar las traducciones completas del inglés al francés. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct t from Traduccion t where t.completa = true and t.idioma.nombre = :al_idioma and t.parrafo.documento.idioma.nombre = :desde_idioma");
		query.setParameter("desde_idioma", "Ingles");
		query.setParameter("al_idioma", "Frances");
		
		List<Traduccion> traducciones = query.list();
		for (Traduccion traduccion : traducciones){
			System.out.println("Traduccion: '" + traduccion.getDescripcion() + "'.");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo F.
	 * Obtiene los emails de los usuarios con alguna cursada aprobada
	 */
	public static void f(){
		System.out.println("F. Obtener los emails de los usuarios con alguna cursada aprobada. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct u from Usuario u where u in ("
						+ "select c.usuario from Cursada c join c.pruebas p "
						+ "where p.puntaje >= 60 "
						+ "and c.usuario = u "
						+ "group by c.curso "
						+ "having count(p) = ("
								+ "select cur.lecciones.size from Curso cur where cur = c.curso))");

		List<Usuario> usuarios = query.list();
		for (Usuario usuario : usuarios){
			System.out.println("Email de usuario con cursada aprobada: " + usuario.getEmail());
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo G.
	 * Obtiene el idioma que define la palabra enviada como parámetro en su diccionario
	 * @param palabra se especifica que palabra por la cual se buscara la definicion.
	 */
	public static void g(String palabra){
		System.out.println("G. Obtener el nombre del idioma que define la palabra enviada como parámetro en	su diccionario. \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct d from Diccionario d join d.definiciones def where index(def) = :palabra");
		query.setString("palabra", palabra);

		List<Diccionario> diccionarios = query.list();
		System.out.println("La palabra '" + palabra + "' es definida por:");
		for (Diccionario d : diccionarios) {
			System.out.println("El idioma '" + d.getIdioma().getNombre() + "'.");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo H.
	 * Obtiene los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma)
	 */
	public static void h(){
		System.out.println("H. Obtener los nombres de los documentos que no tengan ningún párrafo traducido (en ningun idioma). \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("from Documento d where d not in (select doc from Documento doc join doc.parrafos p where p in (select t.parrafo from Traduccion t))");
		
		List<Documento> documentos = query.list();
		for (Documento d : documentos) {
			System.out.println("El documento '" + d.getNombre() + "' no tiene ningun parrafo traducido.");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
	
	/**
	 * Metodo I.
	 * Obtiene los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro
	 * @param idioma se especifica el idioma por el cual se realizara la busqueda.
	 */
	public static void i(String idioma){
		System.out.println("I. Obtener los nombres de los documentos que tengan párrafos sin traducir al idioma de nombre enviado como parámetro \n");
		
		Session session = sessions.openSession();
		Query query = session.createQuery(
				"select distinct d from Documento d join d.parrafos p where p not in (select t.parrafo from Traduccion t where t.idioma.nombre = :nombreIdioma)");
		query.setString("nombreIdioma", idioma);

		List<Documento> documentos = query.list();
		System.out.println("Los siguientes documentos aun tienen parrafos por traducir:");
		for (Documento d : documentos) {
			System.out.println("Documento: '" + d.getNombre() + "'.");
		}
		System.out.println("-------------------------------------------------------------- \n");
		session.close();
	}
}











