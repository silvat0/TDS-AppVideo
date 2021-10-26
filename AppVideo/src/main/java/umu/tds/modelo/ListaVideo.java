package umu.tds.modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListaVideo {
	//Atributos
	private String nombre;
	private List<Video> videos;
	
	//Constructor
	private ListaVideo(String nombre) {
		this.nombre = nombre;
		
		this.videos = new LinkedList<>();
	}

	//Gets
	public String getNombre() {
		return nombre;
	}

	public List<Video> getVideos() {
		return Collections.unmodifiableList(videos);
	}
	
	//Metodos
	//1º metodo --> añadir videos a la lista de videos
	public boolean addVideo(Video...v) {
		return Collections.addAll(videos, v);
	}
	
}
