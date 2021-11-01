package umu.tds.controlador;

import umu.tds.modelo.CatalogoUsuario;
import umu.tds.modelo.Usuario;

public class ControladorAPP {
	
	private CatalogoUsuario cu;
	
	
	
	
	
	
	public boolean login(String user, String password) {
		
		Usuario u = cu.getUsusario(user);
		if (u==null) return false;
		
		if (!u.getContraseña().equals(password)) return false;
		
		return true;
	}
}
