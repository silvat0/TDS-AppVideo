package umu.tds.modelo;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class FiltroAdultos implements IFiltro {
	
	private static final String NETIQUETA = "Adultos";

	@Override
	public boolean isVideoOk(Video v, Usuario u) {

		Date nac = u.getFechaNac();
		long secs18 = 568024668;
		Date d = Date.from(Instant.now().minusSeconds(secs18));
		if (nac.before(d)) {
			return true; //tiene mas de 18
		}
		return !v.getEtiquetas().stream().anyMatch(e -> e.getNombre().equals(NETIQUETA));
	}

}
