package umu.tds.modelo;

public class FiltroAdultos implements IFiltro {
	
	private static final String NETIQUETA = "Adultos";

	@Override
	public boolean isVideoOk(Video v) {
		return !v.getEtiquetas().stream().anyMatch(e -> e.getNombre().equals(NETIQUETA));
	}

}
