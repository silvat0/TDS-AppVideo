package umu.tds.controlador;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import  java.util.stream.Collector;
import java.util.stream.Collectors;

import componente.ComponenteBuscadorVideos;
import componente.VideosEvent;
import componente.VideosListener;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.UsuarioDAO;
import umu.tds.modelo.CatalogoUsuario;
import umu.tds.modelo.CatalogoVideos;
import umu.tds.modelo.Etiqueta;
import umu.tds.modelo.ListaVideo;
import umu.tds.modelo.Usuario;
import umu.tds.modelo.Video;


public class ControladorAPP implements VideosListener {
	
	//Implementacion singleton
	private static ControladorAPP unicaInstancia = null;
	
	//Atributos
	private CatalogoUsuario cu;
	private CatalogoVideos cv;
	private Usuario user;
	private FactoriaDAO factoria;
	private ComponenteBuscadorVideos cargador;
	
	//Constructor
	private ControladorAPP() {
		cu = CatalogoUsuario.getInstancia();
		try {
			factoria = FactoriaDAO.getInstancia();
			cargador = new ComponenteBuscadorVideos();
			cargador.addArchivoListener(this);
			cv = new CatalogoVideos();
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//METODOS
	
	//Implementacion singleton
	public static ControladorAPP getInstancia() {
		if (unicaInstancia == null)
			unicaInstancia = new ControladorAPP();
		return unicaInstancia;
	}
	
	//Para el login
	public boolean login(String user, String password) {
		
		Usuario u = cu.getUsusario(user);
		if (u==null) return false;
		
		if (!u.getContraseña().equals(password)) return false;
		
		this.user=u;
		return true;
	}
	
	//Para el registro
	public boolean existeUsuario(String user) {
		
		return cu.existeUsuario(user);
	}
	
	public Usuario registro(String user, String pass, String email, Date birth, String nombre, String ape){
		
		//Obligatorios.
		if (Stream.of(user,pass,nombre,birth).allMatch(x -> x==null)) 
		{
			return null;
		}
		
		Usuario u = new Usuario(nombre, email, birth, pass, ape, user);
	    if (!cu.addUsuario(u))
			return null;
	    UsuarioDAO uD;
	    uD = factoria.getUsuarioDAO();
		uD.create(u);
		return u;
	}
	
	public Usuario getUsuario() {
		
		return user;
	}
	
	public void cargar(File xml) {
		cargador.buscarVideos(xml);
	}

	private Video parsedVideoToModel(componente.Video compVid) {
		
		List<Etiqueta> le = new ArrayList<>();
		compVid.getEtiqueta().stream()
		.forEach(e -> {
			Etiqueta etq = new Etiqueta(e);
			le.add(etq);
		});
		
		return new Video(compVid.getTitulo(), compVid.getURL(), le);
	}

	@Override
	public void nuevosVideos(VideosEvent arg0) {
		
		List<componente.Video> lv = arg0.getVideos().getVideo();
		for (componente.Video v : lv) {
			Video videoModelo = parsedVideoToModel(v);
			videoModelo.getEtiquetas().stream().forEach(e ->factoria.getEtiquetaDAO().create(e));
			factoria.getVideoDAO().create(videoModelo);
			cv.addVideo(videoModelo);
		}
	}
	
	public List<Video> getVideos(){
		return new ArrayList<Video>(cv.getVideos());
	}
	
	public List<Etiqueta> getEtiquetas() {
		return cv.getEtiquetas();
	}
	
	public void crearListaVideo(String nombre) {
		ListaVideo v = user.crearLista(nombre);
		factoria.getListaVideoDAO().create(v);
		factoria.getUsuarioDAO().update(user);
	}
	
	public boolean eliminarListaVideo(ListaVideo lv) {
		
		factoria.getListaVideoDAO().delete(lv);
		boolean b =user.eliminarListaVideos(lv);
		factoria.getUsuarioDAO().update(user);
		return b;
	}
	
	public void añadirVideoLV(ListaVideo lv, Video...v) {
		
		lv.addVideo(v);
		factoria.getListaVideoDAO().update(lv);
	}
	
	public void eliminarVideoLV(int idxV, ListaVideo lv) {
		
		lv.removeVideo(idxV);
		factoria.getListaVideoDAO().update(lv);
	}
	
	public List<ListaVideo> getAllListaVideo(){
		return user.getListasVideos();
	}
	
	public Optional getLista(String nombre) {
		return getAllListaVideo().stream().filter(l -> l.getNombre().equals(nombre)).findFirst();
	}
	
	
}
