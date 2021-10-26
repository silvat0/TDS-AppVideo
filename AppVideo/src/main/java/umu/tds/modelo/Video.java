package umu.tds.modelo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Video {
	private String url;  
	private String titulo;
	private HashSet<Etiqueta> etiqs;
	
	private Video(String titulo) {
		this.titulo = titulo;
		this.etiqs = new HashSet<>();
	}
	
	//Gets
	public String getUrl() {
		return url;
	}

	public String getTitulo() {
		return titulo;
	}

	public Set<Etiqueta> getEtiq() {
		return Collections.unmodifiableSet(etiqs);
	}
		
	//Metodos
	//1º metodo --> añadir etiquetas al video
	public boolean addEtiqueta(Etiqueta...eti){
		return etiqs.addAll(etiqs);
	}
	
}
