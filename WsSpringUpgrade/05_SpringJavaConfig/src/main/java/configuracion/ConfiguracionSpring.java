package configuracion;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DaoPelicula;

@Configuration
public class ConfiguracionSpring {
	
	@Bean
	@Scope("prototype")
	//<bean id="director" class="modelo.entidad.director" scope="prototype">
	public Director director() {
		Director d = new Director();
		//<property name="nombre" value="Steven Spielberg"/>
		d.setNombre("Steven Spielberg");
		return d;
	}
	@Bean
	@Scope("prototype")
	//Si existe un bean de tipo director dentro del contexto de spring
	//se inyectarua a treaves del parametro. EN esta caso entraria el
	//bean cuyo nombre es "Steven Spielberg"
	public Pelicula pelicula1(Director director) {
		Pelicula pelicula = new Pelicula();
		pelicula.setDirector(director);
		pelicula.setGenero("Sci-fi");
		return pelicula;
	}
	@Bean
	public Pelicula pelicula2() {
		Director d = new Director();
		d.setNombre("George Lucas");
		Pelicula p = new Pelicula();
		p.setDirector(d);
		p.setTitulo("Star Wars");
		return p;
	}
	
	@Bean
	public DaoPelicula daoPelicula() {
		DaoPelicula daoPelicula = new DaoPelicula();
		daoPelicula.setListaPelicula(new ArrayList<Pelicula>());
		daoPelicula.setNumeroMaximoPeliculas(2);
		return daoPelicula;
	}
	
	@Bean
	public GestorPelicula gestorPelicula(DaoPelicula daoPelicula) {
		GestorPelicula gp = new GestorPelicula();
		gp.setDaoPelicula(daoPelicula);
		return gp;
	}
}
