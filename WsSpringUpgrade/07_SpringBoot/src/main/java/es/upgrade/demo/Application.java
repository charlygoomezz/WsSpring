package es.upgrade.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.upgrade.demo.modelo.entidad.Direccion;
import es.upgrade.demo.modelo.entidad.Empleo;
import es.upgrade.demo.modelo.entidad.Persona;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private ApplicationContext context;
	@Autowired
	private Persona p2;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Persona p = context.getBean("persona", Persona.class);
		System.out.println(p2);
		
		Direccion d = new Direccion();
		d.setTipoVia("Sonchans");
		System.out.println(d);
		
		Empleo e = new Empleo("Upgrade", 120000, false);
		e.isBaja();
		System.out.println(e);
	}

}
