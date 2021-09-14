package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

public class Prod01 {
	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// similar a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> registrar un nuevo usuario
		Producto p = new Producto();
		p.setIdprod("P0040");
		p.setDescripcion("Prueba 40");
		p.setIdcategoria(1);
		p.setEstado(1);
		p.setStock(100);
		p.setPrecio(0.99);
		
		em.getTransaction().begin();
		
		em.persist(p);  // <---- registrar
		
		em.getTransaction().commit();
		
		em.close();
		
		
	}
}
