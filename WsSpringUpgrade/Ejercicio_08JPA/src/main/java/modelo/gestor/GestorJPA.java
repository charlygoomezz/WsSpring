package modelo.gestor;

import java.util.Date;
import java.util.List;

import modelo.datos.DaoJPA;
import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class GestorJPA {
    
    private DaoJPA dao = new DaoJPA();
    
    // Agregar un autor 
    public Autor agregarAutor(String nombre, String apellido, Date fechaNacimiento) {
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setApellido(apellido);
        autor.setFechaNacimiento(fechaNacimiento);
        dao.guardarAutor(autor);
        return autor;  // Retorna el autor creado
    }

    // Listar todos los autores
    public List<Autor> listarAutores() {
        return dao.obtenerTodosAutores();
    }

    // Agregar un libro 
    public Libro agregarLibro(String titulo, Double precio, Editorial editorial, Autor autor) {
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setPrecio(precio);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        dao.guardarLibro(libro);
        return libro;  
    }

    // Listar todos los libros
    public List<Libro> listarLibros() {
        return dao.obtenerTodosLibros();
    }

    // Agregar una editorial 
    public Editorial agregarEditorial(String nombre, String direccion) {
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setDireccion(direccion);
        dao.guardarEditorial(editorial);
        return editorial;  
    }

    // Listar todas las editoriales
    public List<Editorial> listarEditoriales() {
        return dao.obtenerTodasEditoriales();
    }

    // Agregar una librería 
    public Libreria agregarLibreria(String nombre, String nombreDuenio, String direccion) {
        Libreria libreria = new Libreria();
        libreria.setNombre(nombre);
        libreria.setNombreDuenio(nombreDuenio);
        libreria.setDireccion(direccion);
        dao.guardarLibreria(libreria);
        return libreria;  
    }

    // Listar todas las librerías
    public List<Libreria> listarLibrerias() {
        return dao.obtenerTodasLibrerias();
    }

    // Agregar un libro a una librería
    public void agregarLibroALibreria(Libreria libreria, Libro libro) {
        dao.agregarLibroALibreria(libreria, libro);  
    }

    // Consultar todos los libros con autor y editorial
    public List<Libro> listarLibrosConAutorYEditorial() {
        return dao.obtenerLibrosConEditorialYAutor();
    }

    // Consultar todos los autores con libros
    public List<Autor> listarAutoresConLibros() {
        return dao.obtenerAutoresConLibros();
    }

    // Consultar todas las librerías con libros
    public List<Libreria> listarLibreriasConLibros() {
        return dao.obtenerLibreriasConLibros();
    }

    // Consultar todos los libros con librerías
    public List<Libro> listarLibrosConLibrerias() {
        return dao.obtenerLibrosConLibrerias();
    }
}
