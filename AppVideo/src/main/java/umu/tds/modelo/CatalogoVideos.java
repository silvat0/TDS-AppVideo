package umu.tds.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CatalogoVideos {
	
	// Singleton
	private static CatalogoVideos unicaInstancia;
	
	private HashMap<String,Video> videos;
	
	public CatalogoVideos() {
		videos = new HashMap<>();
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
}
