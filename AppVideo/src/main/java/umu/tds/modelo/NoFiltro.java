package umu.tds.modelo;

public class NoFiltro implements IFiltro {

	@Override
	public boolean isVideoOk( Video v, Usuario u) {
		return true;
	}

}
