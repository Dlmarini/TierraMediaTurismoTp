package TierraMedia;

import java.util.Iterator;

import java.util.Scanner;



public class AppTierraMedia {

	public static void main(String[] args) throws Throwable {

		ArchivoLyE archivos = new ArchivoLyE("visitantes.txt", "atracciones.txt");

		Sugerencia unaSugerencia = null;

		for (Visitante v : archivos.getListaVisitantes()) {

			unaSugerencia = new Sugerencia(v, archivos.getListaAtracciones());
			Scanner sc = new Scanner(System.in);

			int opcion = 1;

			
			for (Atraccion a : unaSugerencia.getListaOrdenada()) {

				boolean condicionVisitante = v.getMonedas() > 0 && v.getTiempo() > 0;
				boolean condicionAtraccion = a.getCosto() <= v.getMonedas() && a.getDuracion() <= v.getTiempo();

				if (!v.getItinerario().contains(a) && condicionVisitante && condicionAtraccion) {

					System.out.println("\nSugerencia para " + v.getNombre() + "\n" + a.toString() + "");
					System.out.println("Acepta sugerencia ??? (1-S / 0-N)");

					opcion = sc.nextInt();

					if (opcion == 1) {
						v.aceptarSugerencia(a);
					}
				}
			}

			unaSugerencia.imprimirItinerarioDetallado(v);
		}
	}

}
