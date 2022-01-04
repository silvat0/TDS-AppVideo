package umu.tds.modelo;

public enum Filtro {
	
	VACIO("NoFiltro"), 
	ADULTOS("FiltroAdultos"), 
	MIS_LISTAS("FlitroMisListas");
	
	public final String nombre;
	
	private Filtro(String nombre) {
		this.nombre=nombre;
	}

}
