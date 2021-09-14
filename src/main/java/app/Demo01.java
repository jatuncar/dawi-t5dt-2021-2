package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// similar a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> registrar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(123);
		u.setNombre("Eren");
		u.setApellido("Ackerman");
		u.setUsuario("eren@titan.pe");
		u.setClave("1234");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		
		em.persist(u);  // <---- registrar
		
		em.getTransaction().commit();
		
		em.close();
		
		
	}
	
}
