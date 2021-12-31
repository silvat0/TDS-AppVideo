package umu.tds.controlador;

import java.time.LocalDate;
import java.util.stream.Stream;

import umu.tds.modelo.CatalogoUsuario;
import umu.tds.modelo.Usuario;

public class ControladorAPP {
	
	//Implementacion singleton
	private static ControladorAPP unicaInstancia = null;
	
	//Atributos
	private CatalogoUsuario cu;
	
	//Constructor
	private ControladorAPP() {
		cu = CatalogoUsuario.getInstancia();
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
		
		return true;
	}
	
	//Para el registro
	public boolean existeUsuario(String user) {
		
		return cu.existeUsuario(user);
	}
	
	public Usuario registro(String user, String pass, String email, LocalDate birth, String nombre, String ape){
		
		if (Stream.of(user,pass,birth,nombre).allMatch(x -> x==null || x.equals(""))) 
		{
			return null;
		}
		
		LocalDate ld = LocalDate.now();
		Usuario u = new Usuario(nombre, email, ld, pass, ape, user);
	    if (!cu.addUsuario(u))
			return null;
		return u;
	}
	
	
}
