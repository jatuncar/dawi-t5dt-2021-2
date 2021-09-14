package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> validar usando usuario y clave : login con USP
		// String sql = "{call usp_validaAcceso (?,?)}";
		String sql = "{call usp_validaAcceso (:xusr,:xcla)}";
		
		Query query = em.createNativeQuery(sql, Usuario.class);
		query.setParameter("xusr", "U001@gmail.com");
		query.setParameter("xcla", "10001");
		
		// ejecuta la consulta y obtiene el resultado 
		Usuario u = (Usuario) query.getSingleResult();
		
		em.close();
		
		if (u == null) {
			System.out.println("Usuario NO existe, usuario o clave incorrecto");
		} else {
			System.out.println("Bienvenido " + u.getNombre());
		}
		
	}
}
