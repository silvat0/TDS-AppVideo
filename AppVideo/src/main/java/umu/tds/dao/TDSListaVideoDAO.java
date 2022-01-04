package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.ListaVideo;
import umu.tds.modelo.Video;

public class TDSListaVideoDAO implements ListaVideoDAO {
	
	private static final String LISTA_VIDEO = "ListaVideo";
	private static final String NOMBRE = "nombre";
	private static final String VIDEOS = "videos";
	private static final String SEP_VIDEOS = " ";
	
	private ServicioPersistencia sp;
	
	public TDSListaVideoDAO() {
		sp = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	private List<Video> stringToVideos(String videos){
		
		List<Video> lv = new ArrayList<>();
		StringTokenizer strTok = new StringTokenizer(videos, SEP_VIDEOS);
		while (strTok.hasMoreTokens()) {
			try {
				lv.add(FactoriaDAO.getInstancia()
						.getVideoDAO()
						.get(Integer.valueOf((String) strTok.nextElement())));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lv;
	}
	
	private String videosToString(List<Video> lv) {
		
		StringJoiner sj = new StringJoiner(SEP_VIDEOS);
		lv.stream().forEach(e -> sj.add(String.valueOf(e.getId())));
		return sj.toString();
	}
	
	
	private ListaVideo entidadToListaVideo(Entidad eLista) {
		
		String nombre = sp.recuperarPropiedadEntidad(eLista, NOMBRE);
		String videos = sp.recuperarPropiedadEntidad(eLista, VIDEOS);
		
		ListaVideo lv = new ListaVideo(nombre, stringToVideos(videos));
		lv.setId(eLista.getId());
		return lv;
	}
	
	private Entidad listaVideoToEntidad(ListaVideo lista) {
		
		Entidad eLista = new Entidad();
		eLista.setNombre(LISTA_VIDEO);
		
		eLista.setPropiedades(new ArrayList<>(Arrays.asList(
				new Propiedad(NOMBRE, lista.getNombre()),
				new Propiedad(VIDEOS, videosToString(lista.getVideos())
				))));
				
		return eLista;
	}

	@Override
	public void create(ListaVideo lista) {
		Entidad eLista = listaVideoToEntidad(lista);
		eLista = sp.registrarEntidad(eLista);
		lista.setId(eLista.getId());
	}

	@Override
	public boolean delete(ListaVideo lista) {
		Entidad eLista;
		eLista = sp.recuperarEntidad(lista.getId());
		return sp.borrarEntidad(eLista);
	}

	@Override
	public void update(ListaVideo lista) {
		Entidad eLista = sp.recuperarEntidad(lista.getId());
		
		eLista.getPropiedades().stream().forEach(p -> {
			if (p.getNombre().equals(NOMBRE)) {
				p.setValor(lista.getNombre());
			}else if (p.getNombre().equals(VIDEOS)) {
				p.setValor(videosToString(lista.getVideos()));
			}
			sp.modificarPropiedad(p);
		});
	}

	@Override
	public ListaVideo get(int id) {
		Entidad eLista = sp.recuperarEntidad(id);
		return entidadToListaVideo(eLista);
	}

	@Override
	public List<ListaVideo> getAll() {
		
		return sp.recuperarEntidades(LISTA_VIDEO).stream()
				.map(e -> get(e.getId()))
				.collect(Collectors.toList());
	}

}
