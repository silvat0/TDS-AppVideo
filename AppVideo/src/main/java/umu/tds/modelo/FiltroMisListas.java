package umu.tds.modelo;

import umu.tds.controlador.ControladorAPP;

public class FiltroMisListas implements IFiltro {

	@Override
	public boolean isVideoOk(Video v) {
		return ControladorAPP.getInstancia().getUsuario().getListasVideos()
				.stream()
				.flatMap(l -> l.getVideos().stream())
				.anyMatch(vid -> vid.equals(v));
	}

}
