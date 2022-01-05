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
	private int visitas;
	

	public Video(String titulo2, String url2, List<Etiqueta> etiquetas) {
		this(titulo2, url2, etiquetas, 0);
	}
	public Video(String titulo, String url, List<Etiqueta> etiquetas, int visitas) {
		setId(0);
		this.titulo = titulo;
		this.url = url;
		this.etiqs = etiquetas;
		this.visitas = visitas;
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
	
	public boolean tieneEtiqueta(Etiqueta e) {
		return etiqs.contains(e);
	}
	public int getVisitas() {
		return visitas;
	}
	
	public void reproducir() {
		visitas++;
	}
	
}
