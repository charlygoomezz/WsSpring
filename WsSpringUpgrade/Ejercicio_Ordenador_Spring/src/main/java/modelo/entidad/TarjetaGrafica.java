package modelo.entidad;

public class TarjetaGrafica {
	private String marca;
	private String modelo;
	private int nucleoCUDA;
	private double precio;
	private RAM ram;
	public TarjetaGrafica() {
		super();
	}
	public TarjetaGrafica(String marca, String modelo, int nucleoCUDA, double precio, RAM ram) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.nucleoCUDA = nucleoCUDA;
		this.precio = precio;
		this.ram = ram;
	}
	@Override
	public String toString() {
		return "TarjetaGrafica [marca=" + marca + ", modelo=" + modelo + ", nucleoCUDA=" + nucleoCUDA + ", precio="
				+ precio + ", ram=" + ram + "]";
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getNucleoCUDA() {
		return nucleoCUDA;
	}
	public void setNucleoCUDA(int nucleoCUDA) {
		this.nucleoCUDA = nucleoCUDA;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public RAM getRam() {
		return ram;
	}
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	

}
