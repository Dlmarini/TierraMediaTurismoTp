package TierraMedia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
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

	@Test
	public void queLevantaCorrectamenteArchivosTest() throws Throwable {
		
		ArchivoLyE unArchivoL = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		System.out.println(unArchivoL.getListaVisitantes().toString());
		System.out.println(unArchivoL.getListaAtracciones().toString());
	}
	

	@Test
	public void queGeneraSugerenciasOrdenadas() throws Throwable {
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		Sugerencia unaSugerencia = new Sugerencia(unVisitante,unArchivo.getListaAtracciones());
		
		System.out.println(unaSugerencia.getListaOrdenada().toString());
	}  

	@Test
	public void queFuncionaComparador()  throws Throwable {
		
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		LinkedList<Atraccion> listaAux = new LinkedList<Atraccion>();
		listaAux = unArchivo.getListaAtracciones();
		Collections.sort(listaAux, new ComparadorPorCostoYTiempo());
		
		System.out.println(listaAux.toString());
	}
	
	@Test //Probar con archivos erroneos o inexistentes
	public void queTrataExcepcionesArchivoEnLecturaDeArchivo() throws Throwable  {
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		System.out.println(unArchivo.getListaVisitantes().toString());
	}

	
	@Test
	public void queGeneraResumenDeCompraCorrectamente() {
	
		Atraccion a1 = new Atraccion("a1", 2, 1, Tipo.AVENTURA, 6);
		Atraccion a2 = new Atraccion("a2", 3, 2, Tipo.AVENTURA, 5);
		Atraccion a3 = new Atraccion("a3", 5, 5, Tipo.AVENTURA, 10);
		
		
		unVisitante.setItinerario(a1);
		unVisitante.setItinerario(a2);
		unVisitante.setItinerario(a3);
		
		Compra c = new Compra(unVisitante);
		assertEquals(10, c.getCostoTotal(),0.001);
		assertEquals(8, c.getTiempoTotal(), 0.001);
	}
}
