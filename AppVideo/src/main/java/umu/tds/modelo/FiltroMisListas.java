package umu.tds.modelo;



public class FiltroMisListas implements IFiltro {

	@Override
	public boolean isVideoOk(Video v, Usuario u) {
		return u.getListasVideos()
				.stream()
				.flatMap(l -> l.getVideos().stream())
				.anyMatch(vid -> vid.equals(v));
	}

}
