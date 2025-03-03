package es.upgrade.configuracion;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.upgrade.modelo.entidad.Ordenador;
import es.upgrade.modelo.entidad.Periferico;
import es.upgrade.modelo.entidad.PlacaBase;
import es.upgrade.modelo.entidad.Procesador;
import es.upgrade.modelo.entidad.RAM;
import es.upgrade.modelo.entidad.TarjetaGrafica;


@Configuration
public class ConfiguracionSpring {
	
	@Bean
	public Ordenador ordenador(Procesador procesador, TarjetaGrafica tg, 
			RAM ram,Periferico periferico, PlacaBase pb) {
		Ordenador o = new Ordenador();
		o.calcularPrecio();
		o.setPlacaBase(pb);
		o.setProcesador(procesador);
		o.setTarjetaGrafica(tg);
		o.setListaPerifericos(new ArrayList<Periferico>());
		o.setListaRAMs(new ArrayList<RAM>());
		
		return o;
	}
	@Bean
	@Scope("prototype")
	public TarjetaGrafica tg() {
		TarjetaGrafica tg = new TarjetaGrafica();
		tg.setMarca("Nvidia");
		tg.setModelo("RTX-5090");
		tg.setNucleoCUDA(8);
		tg.setPrecio(1000.0);
		tg.getRam();
		return tg;
	}
	@Bean
	@Scope("prototype")
	public RAM ram() {
		RAM ram = new RAM();
		ram.setMarca("Rayzen");
		ram.setPrecio(200);
		ram.setCapacidad(16);
		return ram;
	}
	@Bean
	public Procesador procesador() {
		Procesador procesador = new Procesador();
		procesador.setMarca("Intel");
		procesador.setModelo("i9-7098");
		procesador.setNumeroNucleos(16);
		procesador.setPrecio(879);
		return procesador;
	}
	@Bean
	public PlacaBase placaBase() {
		PlacaBase pb = new PlacaBase();
		pb.setMarca("TXJ");
		pb.setPrecio(300);
		pb.setTipo("Mini");
		return pb;
	}
	@Bean
	@Scope("prototype")
	public Periferico periferico() {
		Periferico p = new Periferico();
		p.setMarca("Logitec");
		p.setPrecio(200);
		p.setTipo("Teclado");
		return p;
		
	}
	
	
	
}
