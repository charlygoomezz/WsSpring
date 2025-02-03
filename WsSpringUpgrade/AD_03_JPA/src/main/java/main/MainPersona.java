package main;

import java.util.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Persona;

public class MainPersona {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Entity manager creado");
		
		Persona persona = new Persona();
		persona.setNombre("Triplet");
		persona.setFechaNacimiento(new Date());
		persona.setCasado(true);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(persona);
		em.persist(persona);
		persona.setNombre("Krilin");
		//No importa cuantas veces uses .persist, porque siempe
		//será el mmismo objeto.
		//Si queremos dar de alta otra entidad, debemos crear 
		//un nuevo objeto
		persona = new Persona();
		persona.setNombre("Tristan");
		em.persist(persona);
		
		persona = new Persona();
		persona.setNombre("Trix");
		Persona p2 = em.merge(persona);//Devuelve la refereancia del objeto gestionado
		persona.setNombre("Son");
		//aqui no se cambia nada porque el objeto Trix es diferente
		//al obk¡jeto Trix que esta gestionado
		p2.setNombre("Son");
		tx.commit();
		
		em.close();

	}

}
