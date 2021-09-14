package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// similar a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> consultar los datos de un usuario
		Usuario u = em.find(Usuario.class, 100);
		
		if (u == null) {
			System.out.println("Usuario NO existe");
		} else {
			System.out.println("Usuario Existe!!!\n" + u);
			em.getTransaction().begin();
			
			em.remove(u);  // <---- eliminar
			
			em.getTransaction().commit();
			System.out.println("Usuario eliminado");
			
		}
		
		em.close();
		
		
	}
}
