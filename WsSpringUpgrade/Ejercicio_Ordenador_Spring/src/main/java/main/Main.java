package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Ordenador;

public class Main {
	
	public static ApplicationContext context;
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("context.xml");
		Ordenador o = context.getBean("ordenador", Ordenador.class);
		System.out.println(o);
		

	}

}
