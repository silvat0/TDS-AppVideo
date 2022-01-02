package umu.tds.modelo;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Video {
	private String url;  
	private String titulo;
	private HashSet<Etiqueta> etiqs;
	

	public Video(String titulo2, String url2, List<Etiqueta> etiquetas) {
		titulo = titulo2;
		url = url2;
		etiqs = new HashSet<>(etiquetas);
		
	}

	//Gets
	public String getUrl() {
		return url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Set<Etiqueta> getEtiquetas() {
		return Collections.unmodifiableSet(etiqs);
	}
		
	//Metodos
	//1º metodo --> añadir etiquetas al video
	public boolean addEtiqueta(Etiqueta...eti){
		return etiqs.addAll(etiqs);
	}
	
}
