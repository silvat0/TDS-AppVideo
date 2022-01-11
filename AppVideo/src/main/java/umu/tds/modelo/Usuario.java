package umu.tds.modelo;


import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	//Atributos
	private static final int MAX_RECIENTES = 5;
	private int id=0;
	private String nombre;
	private String email; 
	private Date fechaNac;
	private String contraseña;
	private String apellidos;
	private String username;
	private boolean premium;
	private List<ListaVideo> listasVideos;
	private List<Video> recientes;
	private IFiltro filtroActivo;
	
	//Constructor
	//de un posible usuario nuevo
	public Usuario(String nombre, String email, Date fechaNac, String contraseña, String apellidos, String usuario) {
		this(nombre, apellidos, email, usuario, fechaNac, contraseña, false, new LinkedList<>(), new NoFiltro(), new LinkedList<>());
	}
	//para la persistencia
	public Usuario(String nombre, String apellidos, String email, 
			String username, Date fechaNac, String contraseña, boolean premium, 
			List<ListaVideo> listasVideos, IFiltro filtro, List<Video> recientes) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email=email;
		this.username = username;
		this.fechaNac = fechaNac;
		this.contraseña = contraseña;
		this.premium = premium;
		this.listasVideos = listasVideos;
		this.filtroActivo = filtro;
		this.recientes = recientes;
	}
	
	//Getters
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	public Date getFechaNac() {
		return fechaNac;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getUsername() {
		return username;
	}

	public List<ListaVideo> getListasVideos() {
		return Collections.unmodifiableList(listasVideos);
	}
	
	public boolean eliminarListaVideos(ListaVideo lv) {
		return listasVideos.removeIf(l -> l.equals(lv));
	}

	//Metodos
	//1º metodo --> Cambiar el valor de premium del usuario
	public void setPremium(boolean b) {
		premium = b;
	}
	
	//2º metodo --> Crear una lista de videos 
	public ListaVideo crearLista(String nombre) {
		
		ListaVideo lv = new ListaVideo(nombre);
		if (listasVideos.contains(lv)) {
			return null;
		}
		listasVideos.add(lv);
		return lv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IFiltro getFiltroActivo() {
		return filtroActivo;
	}

	public void setFiltroActivo(IFiltro filtroActivo) {
		this.filtroActivo = filtroActivo;
	}

	public void addReciente(Video v) {
		recientes.add(0,v);
		int tam = recientes.size(); 
		if (tam==MAX_RECIENTES) {
			recientes.remove(tam-1);
		}
	}

	public List<Video> getRecientes(){
		return Collections.unmodifiableList(recientes);
	}
	
	public Video getUltimoVideo() {
		return recientes.get(0);
	}
}
