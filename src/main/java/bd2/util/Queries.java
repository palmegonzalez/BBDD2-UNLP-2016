package bd2.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bd2.model.Documento;
import bd2.model.Moderador;
import bd2.model.Traduccion;
import bd2.model.Usuario;

public class Queries {
	
	private static SessionFactory sessions;

	public Queries(){}
	
	public static void main(String[] args){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/hibernate.cfg.xml");
		
		sessions = cfg.buildSessionFactory();
		
		//a();
		//b();
		//c();
		//d("2015-07-01", "2015-12-31");
		//e();
		f();
		

	}
	
	public static void a(){
		System.out.println("A.	Listar los nombres de todos los documentos");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("from Documento");
		
		List<Documento> documentos = query.list();
		for (Documento documento : documentos){
			System.out.println("Documento: " + documento.getNombre());
		}
		System.out.println();
		session.close();
	}
	
	public static void b(){
		System.out.println("B.	Listar los emails de los moderadores que hayan evaluado traducciones al inglés");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct m from Moderador m join m.evaluaciones e join e.traduccion t where t.idioma.nombre = :nom_idioma");
		query.setParameter("nom_idioma", "ingles");
		List<Moderador> moderadores = query.list();
		
		for (Moderador moderador : moderadores){
			System.out.println("Email: " + moderador.getEmail());
		}
		System.out.println();
		session.close();
	}
	
	public static void c(){
		System.out.println("C.	Listar los usuarios que hayan iniciado una cursada de Fránces de nivel 3 como mínimo");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct u from Usuario u join u.cursadasRealizadas c where c.curso.idioma.nombre = :nom_idioma and c.curso.nivel >= :nivel");
		query.setParameter("nom_idioma", "Frances");
		query.setParameter("nivel", 3);
		List<Usuario> usuarios = query.list();
		
		for (Usuario usuario : usuarios){
			System.out.println("Nombre: " + usuario.getNombre());
		}
		System.out.println();
		session.close();
	}
	
	public static void d(String fecha_inicio, String fecha_fin){
		System.out.println("D.	Listar moderadores que hayan revisado alguna traducción entre dos fechas pasadas como argumento.");
		
		Session session = sessions.openSession();
		//Query query = session.createQuery("select distinct m from Moderador m join m.evaluaciones e join e.traduccion t where t.");
		Query query = session.createQuery("select distinct m from Moderador m join m.evaluaciones e where e.fecha between :fecha_inicio and :fecha_fin");
		query.setString("fecha_inicio", fecha_inicio);
		query.setString("fecha_fin", fecha_fin);

		List<Moderador> moderadores = query.list();
		
		for (Moderador moderador : moderadores){
			System.out.println("Email: " + moderador.getNombre());
		}
		System.out.println();
		session.close();		
	}
	
	public static void e(){
		System.out.println("C.	Listar las traducciones completas del inglés al francés");
		
		Session session = sessions.openSession();
		Query query = session.createQuery("select distinct t from Traduccion t where t.completa = true and t.idioma.nombre = :al_idioma and t.parrafo.documento.idioma.nombre = :desde_idioma");
		query.setParameter("desde_idioma", "Ingles");
		query.setParameter("al_idioma", "Frances");
		List<Traduccion> traducciones = query.list();
		
		for (Traduccion traduccion : traducciones){
			System.out.println("Nombre: " + traduccion.getDescripcion());
		}
		System.out.println();
		session.close();
	}
	
	public static void f(){
		System.out.println("F.	Obtener los emails de los usuarios con alguna cursada aprobada");
		
		Session session = sessions.openSession();
		//Query query = session.createQuery("select distinct u from Usuario u where u in ( "
		//		+ "select c.usuario u.cursadasRealizadas c where ");
		Query query = session.createQuery("select distinct u from Usuario u where u in ("
						+ "select c.usuario from Cursada c join c.pruebas p "
						+ "where p.puntaje >= 60 "
						+ "and c.usuario = u "
						+ "group by c.curso "
						+ "having count(p) = ("
								+ "select cur.lecciones.size from Curso cur where cur = c.curso))");

		List<Usuario> usuarios = query.list();
		
		for (Usuario usuario : usuarios){
			System.out.println("Usuario con cursada aprobada: " + usuario.getEmail());
		}
		System.out.println();
		session.close();
	}
}
