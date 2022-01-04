package umu.tds.modelo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	//Atributos
	private int id=0;
	private String nombre;
	private String email; 
	private Date fechaNac;
	private String contraseña;
	private String apellidos;
	private String username;
	private boolean premium;
	private List<ListaVideo> listasVideos;
	private IFiltro filtroActivo;
	
	//Constructor
	public Usuario(String nombre, String email, Date fechaNac, String contraseña, String apellidos, String usuario) {
		this(nombre, apellidos, email, usuario, fechaNac, contraseña, false, new LinkedList<>(), new NoFiltro());
	}
	
	public Usuario(String nombre, String apellidos, String email, 
			String username, Date fechaNac, String contraseña, boolean premium, List<ListaVideo> listasVideos, IFiltro filtro) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email=email;
		this.username = username;
		this.fechaNac = fechaNac;
		this.contraseña = contraseña;
		this.premium = premium;
		this.listasVideos = listasVideos;
		this.filtroActivo = filtro;
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
}
