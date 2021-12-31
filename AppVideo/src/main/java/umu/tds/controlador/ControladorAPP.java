package umu.tds.controlador;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;

import umu.tds.dao.FactoriaDAO;
import umu.tds.dao.UsuarioDAO;
import umu.tds.modelo.CatalogoUsuario;
import umu.tds.modelo.Usuario;

public class ControladorAPP {
	
	//Implementacion singleton
	private static ControladorAPP unicaInstancia = null;
	
	//Atributos
	private CatalogoUsuario cu;
	private Usuario user;
	private FactoriaDAO factoria;
	
	//Constructor
	private ControladorAPP() {
		cu = CatalogoUsuario.getInstancia();
		try {
			factoria = FactoriaDAO.getInstancia();
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
	
	
}
