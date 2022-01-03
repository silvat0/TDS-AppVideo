package umu.tds.dao;

import java.util.List;

import umu.tds.modelo.Usuario;
import umu.tds.modelo.Video;

public interface VideoDAO {
	
	void create(Video video);
	boolean delete(Video video);
	void update(Video vide);
	Video get(int id);
	List<Video> getAll();
}
