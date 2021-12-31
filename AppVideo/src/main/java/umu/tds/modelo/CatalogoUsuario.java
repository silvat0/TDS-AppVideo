package umu.tds.modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import umu.tds.dao.FactoriaDAO;

public class CatalogoUsuario {
	
	public static CatalogoUsuario getInstancia() {
		if (unicaInstancia == null) 
			unicaInstancia = new CatalogoUsuario();
		return unicaInstancia;
	}
	
	private static CatalogoUsuario unicaInstancia = null;
	
	//Atributos 
	private Map<String, Usuario> usuarios;
	
	//Construcctor
	private CatalogoUsuario() {
		this.usuarios = new HashMap<>();
		try {
			FactoriaDAO.getInstancia().getUsuarioDAO().getAll().stream().forEach(u -> usuarios.put(u.getUsername(), u));
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	//Metodos
	//1º metodo --> Devolver una lista con todos los usuarios
	public List<Usuario> getUsuarios() {
		LinkedList<Usuario> lista = new LinkedList<>();
		for(Usuario u : usuarios.values()) {
			lista.add(u);
		}
		
		return lista;
	}
	
	//2º metodo --> Devolver un solo usuario por su alias
	public Usuario getUsusario(String alias) {
		return usuarios.get(alias);
	}
	
	//3º metodo --> Devolver un solo usuario por su correo
	public Usuario getUsuario(String correo) {
		for(Usuario u : usuarios.values()) {
			if (u.getEmail().equals(correo)) return u;
		}
		
		return null;
	}
	
	//4º metodo --> añadir un cliente al catalogo
	public boolean addUsuario(Usuario user) {
		if (usuarios.put(user.getUsername(), user) == null)
			return true;
		return false;
	}
	
	//5º metodo --> eliminar a un cliente del catalago
	public void removeUsuario(Usuario user) {
		usuarios.remove(user.getUsername());
	}
	
	public boolean existeUsuario(String user) {
		return usuarios.containsKey(user);
	}
}
