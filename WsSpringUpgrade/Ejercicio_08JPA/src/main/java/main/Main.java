package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.entidad.Autor;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
import modelo.gestor.GestorJPA;


public class Main {

	public static void main(String[] args) {
		GestorJPA gs = new GestorJPA();
		
		//AUTORES
		Autor autor1 = gs.agregarAutor("George", "Orwell", Date.valueOf(LocalDate.of(1903, 6, 25)));
        Autor autor2 = gs.agregarAutor("J.K.", "Rowling", Date.valueOf(LocalDate.of(1965, 7, 31)));
        Autor autor3 = gs.agregarAutor("George", "Orwell", Date.valueOf(LocalDate.of(1903, 6, 25)));
		
        //EDITORIALES 
        Editorial editorial1 = gs.agregarEditorial("Editorial Sudamericana", "Calle Falsa 123");
        Editorial editorial2 = gs.agregarEditorial("Editorial Planeta", "Avenida Siempre Viva 45");

        //LIBROS
        Libro libro1 = gs.agregarLibro("Cien años de soledad", 150.0, editorial1, autor1);
        Libro libro2 = gs.agregarLibro("Harry Potter y la piedra filosofal", 200.0, editorial2, autor2);

        //LIBRERÍAS
        Libreria libreria1 = gs.agregarLibreria("Librería Central", "Juan Pérez", "Calle Mayor 1");
        Libreria libreria2 = gs.agregarLibreria("Librería del Sur", "Ana López", "Avenida del Sol 45");

        //AGREGAR LIBROS A LIBRERÍAS
        gs.agregarLibroALibreria(libreria1, libro1);
        gs.agregarLibroALibreria(libreria2, libro2);

        //LISTAR AUTORES CON LIBROS
        List<Autor> autores = gs.listarAutoresConLibros();
        autores.forEach(a -> System.out.println(a.getNombre() + " " + a.getApellido()));

        //LISTAR LIBROS CON EDITORIAL Y AUTOR
        List<Libro> libros = gs.listarLibrosConAutorYEditorial();
        libros.forEach(l -> System.out.println(l.getTitulo()));
    }
}