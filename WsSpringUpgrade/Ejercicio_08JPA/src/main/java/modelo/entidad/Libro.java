package modelo.entidad;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private Double precio;
	@ManyToOne
	@JoinColumn(name = "editorial_id")
	private Editorial editorial;
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;
	@ManyToMany(mappedBy = "libros")
    private List<Libreria> librerias = new ArrayList<>();
	
}
