package umu.tds.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Stream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import componente.ComponenteBuscadorVideos;
import componente.VideosEvent;
import componente.VideosListener;
import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.UsuarioDAO;
import umu.tds.modelo.CatalogoUsuario;
import umu.tds.modelo.CatalogoVideos;
import umu.tds.modelo.Etiqueta;
import umu.tds.modelo.Filtro;
import umu.tds.modelo.IFiltro;
import umu.tds.modelo.ListaVideo;
import umu.tds.modelo.NoFiltro;
import umu.tds.modelo.Usuario;
import umu.tds.modelo.Video;


public class ControladorAPP implements VideosListener {
	
	private final static String NOMBRE_PAQUETE = "umu.tds.modelo";
	
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
		
		Set<Etiqueta> le = new HashSet<>();
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
	
	public Set<Etiqueta> getEtiquetas() {
		return cv.getEtiquetas();
	}
	
	public ListaVideo crearListaVideo(String nombre) {
		ListaVideo v = user.crearLista(nombre);
		factoria.getListaVideoDAO().create(v);
		factoria.getUsuarioDAO().update(user);
		return v;
	}
	
	public boolean eliminarListaVideo(ListaVideo lv) { 
		
		factoria.getListaVideoDAO().delete(lv);
		boolean b =user.eliminarListaVideos(lv);
		factoria.getUsuarioDAO().update(user);
		return b;
	}
	
	public void añadirVideoLV(ListaVideo lv, List<Video> v) {
		
		lv.addVideo(v);
		factoria.getListaVideoDAO().update(lv);
	}

	public void eliminarVideoLV(List<Video> v, ListaVideo lv) {
		
		/*for(int i : idxV) {
			lv.removeVideo(i);
		}*/
		lv.removeVideo(v);
		factoria.getListaVideoDAO().update(lv);
	}
	
	public void eliminarVideoLV(int[] idx, ListaVideo lv) {
		
		for(int i : idx) {
			lv.removeVideo(i);
		}
		
		factoria.getListaVideoDAO().update(lv);
	}
	
	public List<ListaVideo> getAllListaVideo(){
		return user.getListasVideos();
	}
	
	public Optional<ListaVideo> getLista(String nombre) {
		return getAllListaVideo().stream().filter(l -> l.getNombre().equals(nombre)).findFirst();
	}
	
	public List<Filtro> getFiltros() {
		return Arrays.asList(Filtro.values());
	}
	
	public void setFiltro(Filtro filtro) {
		if (!user.isPremium()) {
			return;
		}
		try {
			IFiltro filtroBusq = (IFiltro) Class.forName(NOMBRE_PAQUETE+"."+filtro.nombre).getDeclaredConstructor().newInstance();
			user.setFiltroActivo(filtroBusq);
			factoria.getUsuarioDAO().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Video> buscar(String titulo, Etiqueta...etiquetas){
		IFiltro filtroActivo;
		if (user.isPremium()) {
			filtroActivo = user.getFiltroActivo();
		} else {
			filtroActivo = new NoFiltro();
		}
		return cv.buscar(user, filtroActivo, titulo, etiquetas);

	}
	
	
	public int getNVideosSistema() {
		return cv.size();
	}
	
	public void reproducir(Video v) {
		user.addReciente(v);
		factoria.getUsuarioDAO().update(user);
		v.reproducir();
		factoria.getVideoDAO().update(v);
	}
	
	public List<Video> getRecientes() {
		return user.getRecientes();
	}
	
	public Video getUltimoVideo() {
		return user.getUltimoVideo();
	}
	
	public boolean añadirEtiqueta(String nombreEt, Video v) {
		
		if (nombreEt.isBlank() ) {
			return false;
		}
		Etiqueta e = new Etiqueta(nombreEt);
		if (!v.addEtiqueta(e)) {
			return false;
		}
		factoria.getEtiquetaDAO().create(e);
		factoria.getUsuarioDAO().update(user);
		return true;
	
	}
	
	public List<Video> getTopTen(){
		//crearListaVideo("Top_10");
		return cv.topX(10);
	}
	
	public void setPremium(boolean b) {
		user.setPremium(b);
		factoria.getUsuarioDAO().update(user);
	}
	public void genPDF() throws FileNotFoundException, DocumentException {
		if(!user.isPremium()) {
			return;
		}
	    String basePath = new File("").getAbsolutePath();
	    System.out.println(basePath);
		FileOutputStream archivo = new FileOutputStream(basePath+"\\file.pdf");
		  Document documento = new Document();
		  PdfWriter.getInstance(documento, archivo);
		  
		  documento.open();
		  rellenarPDF(documento);
		  documento.close();
	}
	private void rellenarPDF(Document d) {
		
		List<ListaVideo> llv = ControladorAPP.getInstancia().getAllListaVideo();
		llv.stream().forEach(lv -> {
			try {
				d.add(new Paragraph("Lista: "+lv.getNombre()));
				d.add(generarParrafoVideos(lv));
				d.add(new Paragraph("\n"));

			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private Paragraph generarParrafoVideos(ListaVideo lv) {
		
		StringJoiner sj = new StringJoiner(";\n");
		lv.getVideos().stream().forEach(v ->{
			sj.add(v.getTitulo());
		});
		return new Paragraph(sj.toString());
	}
	
}
