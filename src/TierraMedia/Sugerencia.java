package TierraMedia;

import java.util.LinkedList;

public class Sugerencia {

	private LinkedList<Atraccion> listaAtracciones;
	private Visitante visitante;
	private LinkedList<Atraccion> listaOrdenada;

	
	public Sugerencia(Visitante unVisitante, LinkedList<Atraccion> listaAtracciones ) {
		this.listaAtracciones = listaAtracciones;
		this.visitante = unVisitante;
		this.listaOrdenada = this.generarListaOrdenada();
	}


	private LinkedList<Atraccion> generarListaOrdenada() {
		
		LinkedList<Atraccion> listaAux = new LinkedList<Atraccion>();
		
		for(Atraccion a : this.listaAtracciones)
			if(a.getTipo() == this.visitante.getPreferencia()) {
				listaAux.add(a);
			}
		
		return listaAux;
	}


	public LinkedList<Atraccion> getListaOrdenada() {
		return listaOrdenada;
	}
	
	
	
}
