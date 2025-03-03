package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Pelicula;

//En este ejemplo vamos a dar de alta el contexto de spring con XML,
//pero vamos a dar de alta los objetos(beans) mediante anotaciones.


public class MainAnotaciones01 {
	
	public static ApplicationContext context = null;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("context01.xml");
		
		Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
		System.out.println(pelicula);
	}

}
