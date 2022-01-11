package umu.tds.modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
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
	public Set<Etiqueta> getEtiquetas() {
		return videos.values().stream()
					 .flatMap(e -> e.getEtiquetas().stream())
					 .collect(Collectors.toSet());
		
		
	}
	
	private boolean estaAlgunaEtiqueta(Video v, Etiqueta...etiquetas) {
		for(Etiqueta e : etiquetas) {
			if (v.tieneEtiqueta(e))
				return true;
		}
		return false;
	}
	
	private String normalizar(String s) {
		String res = s.strip();
		res = res.toLowerCase();
		return res;
	}
	
	public List<Video> buscar(Usuario user, IFiltro filtro, String titulo, Etiqueta...etiquetas){
		
		return videos.values().stream()
			.filter(v -> 
				normalizar(v.getTitulo()).startsWith(normalizar(titulo))
				&& filtro.isVideoOk(v,user)
				&& (etiquetas.length==0 || estaAlgunaEtiqueta(v, etiquetas))
			)
			.collect(Collectors.toList());
	}
	
	public int size() {
		return videos.size();
	}
	
	public List<Video> topX(int nTop){
		return videos.values().stream()
				.sorted((v1,v2) -> ((Integer) v2.getVisitas()).compareTo(v1.getVisitas()))
				.limit(nTop)
				.collect(Collectors.toList());
	}
}
