package umu.tds.modelo;

public class NoFiltro implements IFiltro {

	@Override
	public boolean isVideoOk(Video v) {
		return true;
	}

}
