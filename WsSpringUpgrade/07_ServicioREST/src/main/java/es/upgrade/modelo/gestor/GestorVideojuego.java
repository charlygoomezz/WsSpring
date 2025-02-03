package es.upgrade.modelo.gestor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.persistencia.DaoVideojuego;

public class GestorVideojuego {
	@Autowired
	private DaoVideojuego dao;

	public List<Videojuego> leerVideojuegos() {
		return dao.leerVideojuegos();
	}

	public Integer crearVideojuego(Videojuego v) {
		return dao.crearVideojuego(v);
	}

	public Videojuego leerVideojuegoPorId(int id) {
		return dao.leerVideojuegoPorId(id);
	}

	public List<Videojuego> leerVideojuegoPorNombre(String nombre) {
		return dao.leerVideojuegoPorNombre(nombre);
	}

	public Videojuego updateVidejuego(Videojuego v) {
		return dao.updateVidejuego(v);
	}

	public Integer borrarVideojugoById(int id) {
		return dao.borrarVideojugoById(id);
	}

	public List<Videojuego> leerVideojuegoPorCompania(String compania) {
		return dao.leerVideojuegoPorCompania(compania);
	}

	public List<Videojuego> leerVideojuegoPorNota(Double nota) {
		return dao.leerVideojuegoPorNota(nota);
	}
}
