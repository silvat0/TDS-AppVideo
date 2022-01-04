package umu.tds.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import umu.tds.dao.FactoriaDAO;

public class CatalogoVideos {
	
	// Singleton
	private static CatalogoVideos unicaInstancia;
	
	private HashMap<String,Video> videos;
	
	public CatalogoVideos() {
		videos = new HashMap<>();
		try {
			FactoriaDAO.getInstancia().getVideoDAO().getAll()
			.stream()
			.forEach(v -> videos.put(v.getUrl(), v));
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CatalogoVideos getInstancia() {
		if (unicaInstancia == null) 
			unicaInstancia = new CatalogoVideos();
		return unicaInstancia;
	}
	
	public Collection<Video> getVideos(){
		return Collections.unmodifiableCollection(videos.values());
	}
		
	//Atributos
	public void addVideo(Video v) {
		
		videos.put(v.getUrl(), v);
	}
	
	public void getVideo(String url) {
		videos.get(url);
	}
	
	//Metodos
	//Recoger etiquetas
	public List<Etiqueta> getEtiquetas() {
		return videos.values().stream()
					 .flatMap(e -> e.getEtiquetas().stream())
					 .collect(Collectors.toList());
		
		
	}
}
