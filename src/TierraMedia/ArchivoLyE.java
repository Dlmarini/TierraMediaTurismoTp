package TierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ArchivoLyE {

	private LinkedList<Visitante> listaVisitantes;
	private LinkedList<Atraccion> listaAtracciones;

	public ArchivoLyE(String visitantes, String atracciones) throws FileNotFoundException {

		this.listaVisitantes = generarListaVisitantes(visitantes);
		this.listaAtracciones = generarListaAtracciones(atracciones);
	}

	
	
	private LinkedList<Visitante> generarListaVisitantes(String visitantes) {

		LinkedList<Visitante> listaAux = new LinkedList<Visitante>();
		File visitanteFile = null;

		try {

			visitanteFile = new File(visitantes);

			Scanner sc = new Scanner(visitanteFile);

			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String datos[] = linea.split(" ");

				try {
					String nombre = datos[0];
					double monedas = Double.parseDouble(datos[1]);
					double tiempo = Double.parseDouble(datos[2]);
					Tipo tipo = Tipo.valueOf(datos[3]);

					Visitante unVisitante = new Visitante(nombre, monedas, tiempo, tipo);

					listaAux.add(unVisitante);

				} catch (NumberFormatException nf) {
					System.err.println("Algun dato de el archivo" + visitantes + " es incorrecto ");
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					System.err.println("Falta de dato en archivo" + visitantes);
				}

			}

			sc.close();

		} catch (IOException ioe) {
			System.err.println("El archivo " + visitantes + " o no se encuentra en la ruta especificada");
		}

		return listaAux;
	}

	
	
	
	private LinkedList<Atraccion> generarListaAtracciones(String atracciones) throws FileNotFoundException {

		LinkedList<Atraccion> listaAux = new LinkedList<Atraccion>();
		File atraccionFile = null;

		try {
			atraccionFile = new File(atracciones);

			Scanner sc = new Scanner(atraccionFile);

			while (sc.hasNext()) {
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

		} catch (IOException ioe) {
			System.err.println("El archivo " + atracciones + " o no se encuentra en la ruta especificada");
		}
		return listaAux;

	}

	
	
	public LinkedList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}

	public LinkedList<Visitante> getListaVisitantes() {
		return listaVisitantes;
	}
}
