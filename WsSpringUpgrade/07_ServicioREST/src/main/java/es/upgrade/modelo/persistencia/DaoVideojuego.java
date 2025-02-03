package es.upgrade.modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import es.upgrade.modelo.entidad.Videojuego;

public class DaoVideojuego {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("vJPA");

	public List<Videojuego> leerVideojuegos() {
		EntityManager em = factory.createEntityManager();
		String jpql = "SELECT v FROM Videojuego v";
		TypedQuery<Videojuego> query = em.createQuery(jpql, Videojuego.class);
		return query.getResultList();
	}

	public List<Videojuego> leerVideojuegoPorNombre(String nombre) {
		EntityManager eManager = factory.createEntityManager();
		String jpql = "SELECT v FROM Videojuego v WHERE v.nombre = :nombre"; 
		TypedQuery<Videojuego> query = eManager.createQuery(jpql, Videojuego.class);
		query.setParameter("nombre", nombre); 
		return query.getResultList();
	}

	public List<Videojuego> leerVideojuegoPorCompania(String compania) {
		EntityManager eManager = factory.createEntityManager();
		String jpql = "SELECT v FROM Videojuego v WHERE v.company = :company"; 
		TypedQuery<Videojuego> query = eManager.createQuery(jpql, Videojuego.class);
		query.setParameter("compania", compania); 
		return query.getResultList();
	}

	public List<Videojuego> leerVideojuegoPorNota(Double nota) {
		EntityManager em = factory.createEntityManager();
		String jpql = "SELECT v FROM Videojuego v WHERE v.rating = :nota"; 
		TypedQuery<Videojuego> query = em.createQuery(jpql, Videojuego.class);
		query.setParameter("nota", nota); 
		return query.getResultList();
	}

	public Integer crearVideojuego(Videojuego v) {
		Integer result = null;
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(v);
		transaction.commit();
		em.close();
		return result;
	}

	public Videojuego leerVideojuegoPorId(int id) {
		Videojuego result = null;
		EntityManager eManager = factory.createEntityManager();
		result = eManager.find(Videojuego.class, id);
		eManager.close();
		return result;
	}

	public Videojuego updateVidejuego(Videojuego v) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		transaction.begin();
		v = eManager.merge(v);
		transaction.commit();
		eManager.close();
		return v;
	}

	public Integer borrarVideojugoById(int id) {
		Integer result = null;
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Videojuego v = em.find(Videojuego.class, id);
		em.remove(v);
		transaction.commit();
		em.close();
		return result;
	}
}
