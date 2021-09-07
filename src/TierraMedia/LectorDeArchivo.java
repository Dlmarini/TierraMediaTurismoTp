package TierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LectorDeArchivo {

	
	private LinkedList<Visitante> listaVisitantes;
	private LinkedList<Atraccion> listaAtracciones;
	
	public LectorDeArchivo(String visitantes, String atracciones) throws FileNotFoundException {
		
		this.listaVisitantes = generarListaVisitantes(visitantes);
		this.listaAtracciones = generarListaAtracciones(atracciones);
	}
	
	
	


	private LinkedList<Visitante> generarListaVisitantes(String visitantes) throws FileNotFoundException{
		
		LinkedList<Visitante> listaAux = new LinkedList<Visitante>();
		Scanner sc = new Scanner(new File(visitantes));
		
		while(sc.hasNext()) {
			String linea = sc.nextLine();
			String datos[] = linea.split(" ");
			 
			String nombre = datos[0];
			double monedas = Double.parseDouble(datos[1]);
			double tiempo = Double.parseDouble(datos[2]);
			Tipo tipo = Tipo.valueOf(datos[3]);
			
			Visitante unVisitante = new Visitante(nombre, monedas, tiempo, tipo);
			
			listaAux.add(unVisitante);
			
		}
		sc.close();
		
		return listaAux;
	}
	
	
	
	private LinkedList<Atraccion> generarListaAtracciones(String atracciones) throws FileNotFoundException{
		
		LinkedList<Atraccion> listaAux = new LinkedList<Atraccion>();
		Scanner sc = new Scanner(new File(atracciones));
		
		while(sc.hasNext()) {
			String linea = sc.nextLine();
			String datos[] = linea.split(" ");
			 
			String nombre = datos[0];
			double costo = Double.parseDouble(datos[1]);
			double duracion = Double.parseDouble(datos[2]);
			Tipo tipo = Tipo.valueOf(datos[3]);
			int cupo = Integer.parseInt(datos[4]);
			
			Atraccion unAtraccion = new Atraccion(nombre, costo, duracion, tipo, cupo);
			
			listaAux.add(unAtraccion);
			
		}
		sc.close();
		
		return listaAux;
	}

	

	public LinkedList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}
	
	public LinkedList<Visitante> getListaVisitantes() {
		return listaVisitantes;
	}
}
