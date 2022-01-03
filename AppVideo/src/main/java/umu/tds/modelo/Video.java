package umu.tds.modelo;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Video {
	
	private int id;
	private String url;  
	private String titulo;
	private List<Etiqueta> etiqs;
	

	public Video(String titulo2, String url2, List<Etiqueta> etiquetas) {
		setId(0);
		titulo = titulo2;
		url = url2;
		etiqs = etiquetas;
		
	}

	//Gets
	public String getUrl() {
		return url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public List<Etiqueta> getEtiquetas() {
		return etiqs;
	}
		
	//Metodos
	//1º metodo --> añadir etiquetas al video
	public boolean addEtiqueta(Etiqueta...eti){
		return etiqs.addAll(etiqs);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
