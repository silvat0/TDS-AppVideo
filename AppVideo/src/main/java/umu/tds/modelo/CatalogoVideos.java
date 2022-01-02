package umu.tds.modelo;

import java.util.HashMap;

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
		
	//Atributos
	public void addVideo(Video v) {
		videos.put(v.getUrl(), v);
	}
	
	public void getVideo(String url) {
		videos.get(url);
	}
}
