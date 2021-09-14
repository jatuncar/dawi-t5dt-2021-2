package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> validar usando usuario y clave : login sin USP
		String sql = "SELECT u FROM Usuario u where u.usuario = :xusr and u.clave = :xcla";
		
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		query.setParameter("xusr", "U001@gmail.com");
		query.setParameter("xcla", "10001");
		
		// ejecuta la consulta y obtiene el resultado 
		Usuario u = query.getSingleResult();
		
		em.close();
		
		if (u == null) {
			System.out.println("Usuario NO existe, usuario o clave incorrecto");
		} else {
			System.out.println("Bienvenido " + u.getNombre());
		}
		
	}
	
}
