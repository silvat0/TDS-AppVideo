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
import umu.tds.modelo.Etiqueta;
import umu.tds.modelo.Usuario;
import umu.tds.modelo.Video;

public class TDSVideoDAO implements VideoDAO {
	
	//nombre
	private static final String VIDEO = "video";
	//propiedades
	private static final String URL = "url";
	private static final String TITULO = "titulo";
	private static final String ETIQUETAS = "etiquetas";
	private static final String SEP_ETIQ = " ";
	
	private EtiquetaDAO adaptEtiquetas;
	private ServicioPersistencia sp;
	
	public TDSVideoDAO() {
		sp = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
		try {
			adaptEtiquetas = FactoriaDAO.getInstancia().getEtiquetaDAO();
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private List<Etiqueta> propToEtiquetas(String prop){
		 List<Etiqueta> etiquetas = new ArrayList<>();
		 StringTokenizer strTok = new StringTokenizer(prop, SEP_ETIQ);
		 while (strTok.hasMoreTokens()) {
			 try {
				etiquetas.add(adaptEtiquetas
						 .get(Integer.valueOf((String)strTok.nextElement()))
						 );
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 return etiquetas;	
	}
	
	private String etiquetasToProp(List<Etiqueta> etiquetas) {
		StringJoiner sj = new StringJoiner(SEP_ETIQ);
		etiquetas.stream().forEach(e -> {
			sj.add(String.valueOf(e.getId()));	
		});
		return sj.toString();
	}
	
	private Video entidadToVideo(Entidad eVideo) {
		
		String url = sp.recuperarPropiedadEntidad(eVideo, URL);
		String titulo = sp.recuperarPropiedadEntidad(eVideo, TITULO);
		String etiquetas = sp.recuperarPropiedadEntidad(eVideo, ETIQUETAS);
		
		
		Video v = new Video(titulo, url, propToEtiquetas(etiquetas));
		v.setId(eVideo.getId());
		return v;
	}
	
	private Entidad videoToEntidad(Video video) {
		
		Entidad eVideo = new Entidad();
		eVideo.setNombre(VIDEO);
		
		
		eVideo.setPropiedades(new ArrayList<Propiedad>(Arrays.asList(
				new Propiedad(TITULO, video.getTitulo()),
				new Propiedad(URL, video.getUrl()),
				new Propiedad(ETIQUETAS, etiquetasToProp(video.getEtiquetas())))));
		
		return eVideo;
	}
	

	@Override
	public void create(Video video) {
		
		Entidad eVideo = videoToEntidad(video);
		eVideo = sp.registrarEntidad(eVideo);
		video.setId(eVideo.getId());
		
	}

	@Override
	public boolean delete(Video video) {
		
		Entidad eVideo;
		eVideo = sp.recuperarEntidad(video.getId());
		return sp.borrarEntidad(eVideo);
	}

	@Override
	public void update(Video vide) {
	
		Entidad eVideo = sp.recuperarEntidad(vide.getId());
		
		eVideo.getPropiedades().stream().forEach(p -> {
			
			if (p.getNombre().equals(TITULO)) {
				p.setValor(vide.getTitulo());
			} else if (p.getNombre().equals(URL)) {
				p.setValor(vide.getUrl());
			} else if (p.getNombre().equals(ETIQUETAS)) {
				p.setValor(etiquetasToProp(vide.getEtiquetas()));
			}
			sp.modificarPropiedad(p);
		});
	}

	@Override
	public Video get(int id) {

		Entidad eVideo = sp.recuperarEntidad(id);
		return entidadToVideo(eVideo);
	}

	@Override
	public List<Video> getAll() {
		
		return sp.recuperarEntidades(VIDEO)
				.stream()
				.map(e -> get(e.getId()))
				.collect(Collectors.toList());
	}
	
	


}
