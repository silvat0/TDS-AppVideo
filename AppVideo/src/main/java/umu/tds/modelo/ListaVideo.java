package umu.tds.modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListaVideo {
	//Atributos
	private int id; //persistencia
	private String nombre;
	private List<Video> videos;
	
	//Constructor
	public ListaVideo(String nombre) {
		this(nombre, new LinkedList<>());
	}
	
	public ListaVideo(String nombre, List<Video> videos) {
		setId(0);
		this.nombre = nombre;
		this.videos = videos;
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
	
	public boolean removeVideo(int idx) {
		return videos.remove(idx) != null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
