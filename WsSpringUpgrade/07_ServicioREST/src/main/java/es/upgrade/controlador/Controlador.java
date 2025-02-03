package es.upgrade.controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.upgrade.modelo.entidad.Videojuego;
import es.upgrade.modelo.gestor.GestorVideojuego;

public class Controlador {
	@Autowired
	private GestorVideojuego gv;


	@GetMapping(path = "videojuego", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> getVideogameList(
			@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "compania", required = false) String compania,
			@RequestParam(name = "nota", required = false) Double nota) {
		
		List<Videojuego> listaVideojuegos = null;
		HashSet<Videojuego> hashSet = new HashSet<Videojuego>();

		if (nombre == null && compania == null && nota == null) {
			listaVideojuegos = gv.leerVideojuegos();
		} else {
			if(nombre == null || compania == null || nota == null) {
				
				if (nombre != null){
					listaVideojuegos = gv.leerVideojuegoPorNombre(nombre);
					hashSet.addAll(listaVideojuegos);
				}
				if (compania != null){
					listaVideojuegos = gv.leerVideojuegoPorCompania(compania);
					hashSet.addAll(listaVideojuegos);
				}
				if (nota != null){
					listaVideojuegos = gv.leerVideojuegoPorNota(nota);
					hashSet.addAll(listaVideojuegos);
				}
				
				listaVideojuegos = new ArrayList<Videojuego>(hashSet);
			}
		}

		return new ResponseEntity<List<Videojuego>>(listaVideojuegos, HttpStatus.OK);
	}

	
	@GetMapping(path = "videojuego/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getVideogameById(@PathVariable(name = "id") int id) {

		Videojuego v = gv.leerVideojuegoPorId(id);
		return new ResponseEntity<Videojuego>(v, HttpStatus.OK);
	}


	@PostMapping(path = "videojuego", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> createVideogame(@RequestBody Videojuego v) {

		gv.crearVideojuego(v);
		return new ResponseEntity<Videojuego>(v, HttpStatus.OK);
	}

	
	@PutMapping(path = "videogame", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> updateVideogame(@RequestBody Videojuego v) {

		v = gv.updateVidejuego(v);
		return new ResponseEntity<Videojuego>(v, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "videogame/{id}")
	public ResponseEntity<Videojuego> deleteVideogameByID(@PathVariable(name = "id") int id) {

		gv.borrarVideojugoById(id);
		return new ResponseEntity<Videojuego>(HttpStatus.OK);
	}
}
