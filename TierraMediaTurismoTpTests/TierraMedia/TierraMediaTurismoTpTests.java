package TierraMedia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Test;

public class TierraMediaTurismoTpTests {

	Visitante unVisitante = new Visitante("Eowyn", 10, 8, Tipo.DEGUSTACION);
	Atraccion unaAtraccion = new Atraccion("Moria", 10, 2, Tipo.AVENTURA, 6);

	@Test
	public void queContruyeObjetosNoNulosTest() {

		assertNotNull(unVisitante);
		assertNotNull(unaAtraccion);
	}

	@Test
	public void queLevantaCorrectamenteArchivosTest() throws FileNotFoundException {
		
		ArchivoLyE unArchivoL = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		System.out.println(unArchivoL.getListaVisitantes().toString());
		System.out.println(unArchivoL.getListaAtracciones().toString());
	}
	

	@Test
	public void queGeneraSugerenciasOrdenadas() throws FileNotFoundException {
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		Sugerencia unaSugerencia = new Sugerencia(unVisitante,unArchivo.getListaAtracciones());
		
		System.out.println(unaSugerencia.getListaOrdenada().toString());
	}  

	@Test
	public void queFuncionaComparador() throws FileNotFoundException  {
		
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		LinkedList<Atraccion> listaAux = new LinkedList<Atraccion>();
		listaAux = unArchivo.getListaAtracciones();
		Collections.sort(listaAux, new ComparadorPorCostoYTiempo());
		
		System.out.println(listaAux.toString());
	}
	
	@Test /*(expected = Exception.class)*/
	public void queTrataExcepcionesArchivoEnLecturaDeArchivo() throws NumberFormatException, FileNotFoundException {
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		
		System.out.println(unArchivo.getListaVisitantes().toString());
	}
	
	@Test 
	public void queGeneraListaOrdenadaCorrectamente() throws NumberFormatException, FileNotFoundException {
		ArchivoLyE unArchivo = new ArchivoLyE("visitantes.txt", "atracciones.txt");
		Sugerencia unaSugerencia = new Sugerencia(unVisitante, unArchivo.getListaAtracciones());
		
		System.out.println(unaSugerencia.getListaOrdenada().toString()); 
	}
	
}
