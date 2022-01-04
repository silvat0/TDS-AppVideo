package umu.tds.dao;

import java.util.List;

import umu.tds.modelo.ListaVideo;

public interface ListaVideoDAO {

	
	void create(ListaVideo lista);
	boolean delete(ListaVideo lista);
	void update(ListaVideo lista);
	ListaVideo get(int id);
	List<ListaVideo> getAll();

}
