package TierraMedia;

import java.util.LinkedList;

public class Visitante {

	
	private String nombre;
	private double monedas;
	private double tiempo;
	private Tipo preferencia;
    private LinkedList<Atraccion> itinerario; 

	public Visitante(String nombre, double monedas, double tiempo, Tipo preferencia) {
		this.nombre = nombre;
		this.monedas = monedas;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		this.itinerario = null;
	}

	
	public void aceptarSugerencia(LinkedList<Atraccion> unaAtraccion) {
		if(unaAtraccion.get)
	}
	public String getNombre() {
		return nombre;
	}

	

	public double getMonedas() {
		return monedas;
	}


	public double getTiempo() {
		return tiempo; 
	}

	

	public Tipo getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Tipo preferencia) {
		this.preferencia = preferencia;
	}

	public LinkedList<Atraccion> getItinerario() {
		return itinerario;
	}

	public void setItinerario(Atraccion unaAtraccion) {
		
		this.itinerario.add(unaAtraccion);
	}


	@Override
	public String toString() {
		return "Visitante [nombre=" + nombre + ", monedas=" + monedas + ", tiempo=" + tiempo + ", preferencia="
				+ preferencia + "]\n";
	}
	
	
}
