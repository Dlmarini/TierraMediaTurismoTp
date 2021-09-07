package TierraMedia;

import java.util.Comparator;

public class ComparadorPorCostoYTiempo implements Comparator<Atraccion>{

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		
		if(a1.getCosto() > a2.getCosto()) {
			return -1;
		}else if(a1.getCosto() < a2.getCosto()) {
			return 1;
		}
		
		if(a1.getDuracion() > a2.getDuracion()) {
			return -1;
		}else if(a1.getDuracion() < a2.getDuracion()) {
			return 1;
		}
		return 0;
	}

	
}
