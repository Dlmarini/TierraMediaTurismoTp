package TierraMedia;

import java.util.Objects;

public class Atraccion {

	private String nombre;
	private double costo;
	private double duracion;
	private Tipo tipo;
	private int cupo;

	
	public Atraccion(String nombre, double costo, double duracion, Tipo tipo, int cupo) {
		this.nombre = nombre;
		this.costo = costo;
		this.duracion = duracion;
		this.tipo = tipo;
		this.cupo = cupo; 
		
	} 

	public Atraccion() {
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", duracion=" + duracion + ", tipo=" + tipo
				+ ", cupo=" + cupo + "]\n";
	}





	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, duracion, nombre, tipo);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo) && cupo == other.cupo
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(nombre, other.nombre) && tipo == other.tipo;
	}





	public String getNombre() {
		return nombre; 
	}


	public double getCosto() {
		return costo;
	}



	public double getDuracion() {
		return duracion;
	}


	public Tipo getTipo() {
		return tipo;
	}



	public int getCupo() {
		return cupo;
	}

	
	
}
