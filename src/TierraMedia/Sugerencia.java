package TierraMedia;

import java.util.Collections;
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
		
		LinkedList<Atraccion> listaAux1 = new LinkedList<Atraccion>();
		LinkedList<Atraccion> listaAux2 = new LinkedList<Atraccion>();
		LinkedList<Atraccion> listaOrdenada = new LinkedList<Atraccion>();
		listaAux1.clear();
		listaAux2.clear();
		listaOrdenada.clear();
		
		for(Atraccion a : this.listaAtracciones)
			if(a.getTipo() == this.visitante.getPreferencia()) {
				listaAux1.add(a);
			}else if(a.getTipo() != this.visitante.getPreferencia()) {
				listaAux2.add(a);
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
	
	
	
}
