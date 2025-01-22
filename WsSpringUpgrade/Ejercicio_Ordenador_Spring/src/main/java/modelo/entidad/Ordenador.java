package modelo.entidad;

import java.util.ArrayList;

public class Ordenador {
	private double precio;
	private Procesador procesador;
	private TarjetaGrafica tarjetaGrafica;
	private PlacaBase placaBase;
	private ArrayList <RAM>listaRAMs;
	private ArrayList<Periferico> listaPerifericos;
	
	public Ordenador() {
		super();
	}
	public Ordenador(double precio, Procesador procesador, TarjetaGrafica tarjetaGrafica, PlacaBase placaBase,
			ArrayList<RAM> listaRAMs, ArrayList<Periferico> listaPerifericos) {
		super();
		this.precio = precio;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
		this.placaBase = placaBase;
		this.listaRAMs = listaRAMs;
		this.listaPerifericos = listaPerifericos;
	}
	@Override
	public String toString() {
		return "Ordenador [precio=" + precio + ", procesador=" + procesador + ", tarjetaGrafica=" + tarjetaGrafica
				+ ", placaBase=" + placaBase + ", listaRAMs=" + listaRAMs + ", listaPerifericos=" + listaPerifericos
				+ "]";
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Procesador getProcesador() {
		return procesador;
	}
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}
	public TarjetaGrafica getTarjetaGrafica() {
		return tarjetaGrafica;
	}
	public void setTarjetaGrafica(TarjetaGrafica tarjetaGrafica) {
		this.tarjetaGrafica = tarjetaGrafica;
	}
	public PlacaBase getPlacaBase() {
		return placaBase;
	}
	public void setPlacaBase(PlacaBase placaBase) {
		this.placaBase = placaBase;
	}
	public ArrayList<RAM> getListaRAMs() {
		return listaRAMs;
	}
	public void setListaRAMs(ArrayList<RAM> listaRAMs) {
		this.listaRAMs = listaRAMs;
	}
	public ArrayList<Periferico> getListaPerifericos() {
		return listaPerifericos;
	}
	public void setListaPerifericos(ArrayList<Periferico> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}
	
	public double calcularPrecio() {
		this.precio = this.precio + procesador.getPrecio() + 
				tarjetaGrafica.getPrecio() + placaBase.getPrecio();
		// Recorremos los arrays con un for each y accedemos a los precios
		for(RAM r : listaRAMs) {
			this.precio += r.getPrecio();
		}
		for(Periferico p : listaPerifericos) {
			this.precio += p.getPrecio();
		}
	
		
		return this.precio;
	}

}
