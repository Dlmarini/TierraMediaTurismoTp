package TierraMedia;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;





;

public class AppTierraMedia { 

	public static void main(String[] args) throws Throwable {
		
		ArchivoLyE archivos = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		Sugerencia unaSugerencia = null;
		
		
		
		for(Visitante v : archivos.getListaVisitantes()) {
			
			 unaSugerencia = new Sugerencia(v, archivos.getListaAtracciones());
			 
			 LinkedList<Atraccion> listaAux = unaSugerencia.getListaOrdenada();
			 Iterator<Atraccion> itr = listaAux.iterator();
			 
			 int opcion = 1;
			 
			 while(itr.hasNext() && v.getMonedas() > 0 && v.getTiempo() > 0 ) {
				
				 
				 System.out.println("Sugerencia --> "+ itr.next().toString()+"\n" );
				 System.out.println("Acepta sugerencia ??? (1- SI / 0- NO)");
				 
				
				
				
			}
			
		}
	}
	
	
	
}
