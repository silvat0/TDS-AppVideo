package umu.tds.dao;

import java.util.List;

import umu.tds.modelo.Etiqueta;
import umu.tds.modelo.Usuario;

public interface EtiquetaDAO {
	
	void create(Etiqueta tag);
	boolean delete(Etiqueta tag);
	void update(Etiqueta tag);
	Etiqueta get(int id);
	List<Etiqueta> getAll();
}
