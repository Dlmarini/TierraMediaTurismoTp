package TierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class ArchivoLyE {

	private LinkedList<Visitante> listaVisitantes;
	private LinkedList<Atraccion> listaAtracciones;

	public ArchivoLyE(String visitantes, String atracciones) throws Throwable {

		this.listaVisitantes = generarListaVisitantes(visitantes);
		this.listaAtracciones = generarListaAtracciones(atracciones);
	}

	private LinkedList<Visitante> generarListaVisitantes(String visitantes) {

		LinkedList<Visitante> listaAux = new LinkedList<Visitante>();
		File visitanteFile = null;
		Scanner sc = null;

		try {

			visitanteFile = new File(visitantes);
			sc = new Scanner(visitanteFile);
		} catch (FileNotFoundException fnfe) {
			System.err.println("El archivo no existe o la ruta es incorrecta!!!");
		}

		while (sc.hasNext()) {
			try {
				String linea = sc.nextLine();
				String datos[] = linea.split(" ");

				String nombre = datos[0];
				double monedas = Double.parseDouble(datos[1]);
				double tiempo = Double.parseDouble(datos[2]);
				Tipo tipo = Tipo.valueOf(datos[3]);

				Visitante unVisitante = new Visitante(nombre, monedas, tiempo, tipo);

				listaAux.add(unVisitante);
			} catch (NumberFormatException nfe) {
				System.err.println("Dato erroneo en el archivo " + visitantes);
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.err.println("dato faltante en el archivo " + visitantes);
			}
		}

		sc.close();

		return listaAux;
	}

	private LinkedList<Atraccion> generarListaAtracciones(String atracciones) {

		LinkedList<Atraccion> listaAux = new LinkedList<Atraccion>();
		File atraccionFile = null;
		Scanner sc = null;

		try {

			atraccionFile = new File(atracciones);
			sc = new Scanner(atraccionFile);

		} catch (FileNotFoundException fnfe) {
			System.err.println("El archivo no existe o la ruta es incorrecta!!!");
		}

		while (sc.hasNext()) {
			try {
				String linea = sc.nextLine();
				String datos[] = linea.split(" ");

				String nombre = datos[0];
				double costo = Double.parseDouble(datos[1]);
				double duracion = Double.parseDouble(datos[2]);
				Tipo tipo = Tipo.valueOf(datos[3]);
				int cupo = Integer.parseInt(datos[4]);

				Atraccion unAtraccion = new Atraccion(nombre, costo, duracion, tipo, cupo);

				listaAux.add(unAtraccion);

			} catch (NumberFormatException nfe) {
				System.err.println("Dato erroneo en el archivo " + atracciones);
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.err.println("Dato faltante en el archivo " + atracciones);
			}
		}

		sc.close();

		return listaAux;
	}

	public void escribirArchivoDeSalida(Compra unaCompra) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(unaCompra.getUnVisitante().getNombre() + ".out"));
		salida.println(unaCompra.getUnVisitante().toString());
		salida.println(unaCompra.toString());
		salida.close();
	}

	public LinkedList<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}

	public LinkedList<Visitante> getListaVisitantes() {
		return listaVisitantes;
	}
}
