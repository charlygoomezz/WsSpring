package main.OneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Cliente;
import modelo.entidad.CuentaBancaria;
import modelo.entidad.Tarea;

public class OneToMany {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Tarea t1 = new Tarea();
		t1.setContenido("Ir alli");
		t1.setImportancia("Mucha");
		
		Tarea t2 = new Tarea();
		t2.setContenido("Poca");
		t2.setImportancia("No ir");
		
		List<Tarea> listaTareas =  new ArrayList<Tarea>();
		listaTareas.add(t1);
		listaTareas.add(t2);
		
		Cliente c1 = new Cliente();
		c1.setNombre("Sonni");
		c1.setTelefono("657898765");
		c1.setListaTareas(listaTareas);
		
		//em.persist(t1);
		//em.persist(t2);
		em.persist(c1);
		et.commit();
		em.close();
		
				
		

	}

}
