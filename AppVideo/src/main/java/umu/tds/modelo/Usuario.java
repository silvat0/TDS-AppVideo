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
	private List<ListaVideo> listavideos;
	
	//Constructor
	public Usuario(String nombre, String email, Date fechaNac, String contraseña, String apellidos, String usuario) {
		this.nombre = nombre;
		this.email = email;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.contraseña = contraseña;
		this.username = usuario;
		
		this.premium = false;
		this.listavideos = new LinkedList<>();
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

	public List<ListaVideo> getListavideos() {
		return Collections.unmodifiableList(listavideos);
	}

	//Metodos
	//1º metodo --> Cambiar el valor de premium del usuario
	public void setPremium(boolean b) {
		premium = b;
	}
	
	//2º metodo --> Crear una lista de videos 
	public boolean crearLista(String nombre) {
		
		ListaVideo lv = new ListaVideo(nombre);
		return listavideos.add(lv);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
