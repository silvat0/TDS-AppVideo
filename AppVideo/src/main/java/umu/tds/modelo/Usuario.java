package umu.tds.modelo;

import java.time.LocalDate;

public class Usuario {
	//Atributos
	private String nombre;
	private String email; 
	private LocalDate fechaNac;
	private String contraseña;
	private String apellidos;
	private String usuario;
	private boolean premium;
	
	//Constructor
	private Usuario(String nombre, String email, LocalDate fechaNac, String contraseña, String apellidos, String usuario) {
		this.nombre = nombre;
		this.email = email;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.contraseña = contraseña;
		this.usuario = usuario;
		this.premium = false;
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

	//Metodos
	public void setPremium() {
		premium = !premium;
	}

}
