package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Coche;
import modelo.entidad.Persona;

public class MainJPABuscar {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Entity manager creado");
		
		Persona persona = em.find(Persona.class,1);
		persona = em.find(Persona.class, 1);
		em.clear();
		
		System.out.println(persona);
		em.close();
		
	}
}

