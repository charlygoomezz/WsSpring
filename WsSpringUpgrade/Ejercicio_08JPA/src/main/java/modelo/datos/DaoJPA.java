package modelo.datos;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class DaoJPA {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Librerias");

    // Guardar un autor en la base de datos
    public void guardarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }

    // Obtener todos los autores
    public List<Autor> obtenerTodosAutores(){
        EntityManager em = emf.createEntityManager();
        List<Autor> listaAutores = em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        em.close();
        return listaAutores;
    }

    // Guardar un libro
    public void guardarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }

    // Obtener todos los libros
    public List<Libro> obtenerTodosLibros(){
        EntityManager em = emf.createEntityManager();
        List<Libro> listaLibros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        em.close();
        return listaLibros;
    }

    // Guardar una editorial
    public void guardarEditorial(Editorial editorial) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
        em.close();
    }

    // Obtener todas las editoriales
    public List<Editorial> obtenerTodasEditoriales(){
        EntityManager em = emf.createEntityManager();
        List<Editorial> listaEditoriales = em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
        em.close();
        return listaEditoriales;
    }

    // Guardar una librería
    public void guardarLibreria(Libreria libreria) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libreria);
        em.getTransaction().commit();
        em.close();
    }

    // Obtener todas las librerías
    public List<Libreria> obtenerTodasLibrerias(){
        EntityManager em = emf.createEntityManager();
        List<Libreria> listaLibrerias = em.createQuery("SELECT lb FROM Libreria lb", Libreria.class).getResultList();
        em.close();
        return listaLibrerias;
    }

    // Agregar un libro a una librería (relación N a M)
    public void agregarLibroALibreria(Libreria libreria, Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        libreria.getColeccionLibros().add(libro);  
        em.merge(libreria);  // Guarda la relación en la base de datos
        em.getTransaction().commit();
        em.close();
    }

    // Consultar todos los libros con su autor y editorial
    public List<Libro> obtenerLibrosConEditorialYAutor() {
        EntityManager em = emf.createEntityManager();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.editorial JOIN FETCH l.autor", Libro.class).getResultList();
        em.close();
        return libros;
    }

    // Consultar todos los autores con sus libros
    public List<Autor> obtenerAutoresConLibros() {
        EntityManager em = emf.createEntityManager();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a JOIN FETCH a.libros", Autor.class).getResultList();
        em.close();
        return autores;
    }

    // Consultar todas las librerías con sus libros
    public List<Libreria> obtenerLibreriasConLibros() {
        EntityManager em = emf.createEntityManager();
        List<Libreria> librerias = em.createQuery("SELECT lb FROM Libreria lb JOIN FETCH lb.libros", Libreria.class).getResultList();
        em.close();
        return librerias;
    }

    // Consultar todos los libros con las librerías donde están
    public List<Libro> obtenerLibrosConLibrerias() {
        EntityManager em = emf.createEntityManager();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l JOIN FETCH l.librerias", Libro.class).getResultList();
        em.close();
        return libros;
    }
}
