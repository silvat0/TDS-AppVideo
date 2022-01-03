package umu.tds.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import umu.tds.modelo.Etiqueta;

public class TDSEtiquetaDAO implements EtiquetaDAO{
	
	private static final String ETIQUETA = "Etiqueta";
	
	private static final String NOMBRE = "nombre";
	
	private ServicioPersistencia sp;
	
	public TDSEtiquetaDAO() {
		
		sp = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	private Etiqueta entidadToEtiqueta(Entidad eEtiqueta) {
		
		String nombre = sp.recuperarPropiedadEntidad(eEtiqueta, NOMBRE);
		
		Etiqueta e = new Etiqueta(nombre);
		e.setId(eEtiqueta.getId());
		return e;
	}
	
	private Entidad etiquetaToEntidad(Etiqueta tag) {
		
		Entidad eTag = new Entidad();
		eTag.setNombre(ETIQUETA);
		eTag.setPropiedades(new ArrayList<>(Arrays.asList(
				new Propiedad(NOMBRE, tag.getNombre()))));
		
		return eTag;
	}
	
	public void create(Etiqueta tag) {
		Entidad eTag = etiquetaToEntidad(tag);
		eTag = sp.registrarEntidad(eTag);
		tag.setId(eTag.getId());
	}
	
	public boolean delete(Etiqueta tag) {
		Entidad eTag;
		eTag = sp.recuperarEntidad(tag.getId());
		return sp.borrarEntidad(eTag);
	}
	
	public void update(Etiqueta tag) {
		Entidad eTag = sp.recuperarEntidad(tag.getId());
		
		eTag.getPropiedades().stream().forEach(p -> {
			if (p.getNombre().equals(NOMBRE)) {
				p.setValor(tag.getNombre());
			}
			sp.modificarPropiedad(p);
		});
	}
	
	public Etiqueta get(int id) {
		Entidad eTag = sp.recuperarEntidad(id);
		return entidadToEtiqueta(eTag);
	}
	
	public List<Etiqueta> getAll(){
		
		return sp.recuperarEntidades().stream()
				.map(e -> this.get(e.getId()))
				.collect(Collectors.toList());
	}
}
