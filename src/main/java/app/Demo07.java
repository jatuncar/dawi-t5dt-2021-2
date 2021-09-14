package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo07 {
	
	public static void main(String[] args) {
		// similar a DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// similar a crear el obj DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso -> consultar los datos de un usuario
		// em.createQuery("sentencia de consulta JPQL", claseDeResultado)
		
		System.out.println("--- Listado de todos los Usuarios ---");
		List<Usuario> lstUsuarios = em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
		System.out.println("Cantidad de usuarios : " + lstUsuarios.size());
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		} 
		System.out.println("------------------------------------------");
		
		
		System.out.println("--- Listado de los Usuarios de tipo 2 ---");
		// -- define la cadena
		String sql = "SELECT u FROM Usuario u where u.tipo = :xtipo";
		// prepara la consulta
		TypedQuery<Usuario> query = em.createQuery(sql, Usuario.class);
		// setea los parámetros
		query.setParameter("xtipo", 2);
		// ejecuta la consulta y convierte el resultado en un List
		List<Usuario> lstUsuarios2 = query.getResultList();
		// muestra el resultado
		System.out.println("Cantidad de usuarios : " + lstUsuarios2.size());
		for (Usuario u : lstUsuarios2) {
			System.out.println(u);
		} 
		System.out.println("------------------------------------------");
		
		
		
		
		
		
		em.close();
		
		
		
	}
}
