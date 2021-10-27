package umu.tds.modelo;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	//Atributos
	private String nombre;
	private String email; 
	private LocalDate fechaNac;
	private String contraseña;
	private String apellidos;
	private String usuario;
	private boolean premium;
	private List<ListaVideo> listavideos;
	
	//Constructor
	private Usuario(String nombre, String email, LocalDate fechaNac, String contraseña, String apellidos, String usuario) {
		this.nombre = nombre;
		this.email = email;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.contraseña = contraseña;
		this.usuario = usuario;
		
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
	
	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public List<ListaVideo> getListavideos() {
		return Collections.unmodifiableList(listavideos);
	}

	//Metodos
	//1º metodo --> Cambiar el valor de premium del usuario
	public void setPremium() {
		premium = !premium;
	}
	
	//2º metodo --> Crear una lista de videos 
	public boolean crearLista(String nombre) {
		
		ListaVideo lv = new ListaVideo(nombre);
		return listavideos.add(lv);
	}
}
