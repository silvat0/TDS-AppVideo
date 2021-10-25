package umu.tds.modelo;

public class Video {
	private String url;
	private String titulo;
	private Etiqueta etiq;
	
	private Video(String titulo, Etiqueta etiq) {
		this.titulo = titulo;
		this.etiq = etiq;
		
	}
}
