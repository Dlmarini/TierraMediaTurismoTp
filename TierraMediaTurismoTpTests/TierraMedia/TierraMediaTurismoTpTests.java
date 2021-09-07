package TierraMedia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

public class TierraMediaTurismoTpTests {

	Visitante unVisitante = new Visitante("Eowyn", 10, 8, Tipo.AVENTURA);
	Atraccion unaAtraccion = new Atraccion("Moria", 10, 2, Tipo.AVENTURA, 6);
	
	@Test
	public void queContruyeObjetosNoNulosTest() {
		
		assertNotNull(unVisitante);
		assertNotNull(unaAtraccion);
	}
	

/*	@Test
	public void queLevantaCorrectamenteArchivosTest() throws FileNotFoundException {
		
		LectorDeArchivo unArchivo = new LectorDeArchivo("visitantes.txt","atracciones.txt");
		
		System.out.println(unArchivo.getListaVisitantes().toString());
		System.out.println(unArchivo.getListaAtracciones().toString());
	}*/
	
	@Test
	public void queLevantaComparaCorrectamente() throws FileNotFoundException {
		
		LinkedList<Atraccion> auxiliar = new LinkedList<Atraccion>();
		
		LectorDeArchivo unArchivo = new LectorDeArchivo("visitantes.txt","atracciones.txt");
		
		auxiliar = unArchivo.getListaAtracciones();
		
		Collections.sort(auxiliar, new ComparadorPorCostoYTiempo());
		System.out.println(auxiliar.toString());
		
	}

}
