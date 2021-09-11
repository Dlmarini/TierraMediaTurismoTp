package TierraMedia;

import java.util.Collections;
import java.util.LinkedList;

public class Sugerencia {

	private LinkedList<Atraccion> listaAtracciones;
	private Visitante visitante;
	private LinkedList<Atraccion> listaOrdenada;
	

	public Sugerencia(Visitante unVisitante, LinkedList<Atraccion> listaAtracciones) {
		this.listaAtracciones = listaAtracciones;
		this.visitante = unVisitante;
		this.listaOrdenada = this.generarListaOrdenada();
		
	}

	private LinkedList<Atraccion> generarListaOrdenada() {

		LinkedList<Atraccion> listaAux1 = new LinkedList<Atraccion>();
		LinkedList<Atraccion> listaAux2 = new LinkedList<Atraccion>();
		LinkedList<Atraccion> listaOrdenada = new LinkedList<Atraccion>();

		for (Atraccion a : this.listaAtracciones) {

			if (a.getDuracion() <= this.visitante.getTiempo() && a.getCosto() <= this.visitante.getMonedas()) {

				if (a.getTipo() == this.visitante.getPreferencia()) {
					listaAux1.add(a);
				} else if (a.getTipo() != this.visitante.getPreferencia()) {
					listaAux2.add(a);
				}
			}
		}
		Collections.sort(listaAux1, new ComparadorPorCostoYTiempo());
		Collections.sort(listaAux2, new ComparadorPorCostoYTiempo());

		listaOrdenada.addAll(listaAux1);
		listaOrdenada.addAll(listaAux2);

		return listaOrdenada;
	}

	public LinkedList<Atraccion> getListaOrdenada() {

		return listaOrdenada;

	}

	public void imprimirItinerarioDetallado(Visitante unVisitante) {
		LinkedList<Atraccion> listaAux = unVisitante.getItinerario();
		double costoTotal = 0;
		double tiempoTotal = 0;

		System.out.println("****Resumen de compra del visitante " + unVisitante.getNombre() + "****");
		for (Atraccion a : listaAux) {
			System.out.println(a.getNombre());
			costoTotal += a.getCosto();
			tiempoTotal += a.getDuracion();
		}

		System.out.println("Costo final de la compra : " + costoTotal);
		System.out.println("Tiempo requerido : " + tiempoTotal);
		
		
	}

}
