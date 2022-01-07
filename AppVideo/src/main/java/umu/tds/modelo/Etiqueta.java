package umu.tds.modelo;

import java.util.Objects;

public class Etiqueta {
	//Atributos
	private int id; //persistencia
	private String nombre;
	
	//Constructor
	public Etiqueta(String nombre) {
		setId(0);
		this.nombre = nombre;
	}

	//Get
	public String getNombre() {
		return nombre;
	}

	//HashCode & equals
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null) return false;
		
		if (getClass() != obj.getClass()) return false;
		
		Etiqueta other = (Etiqueta) obj;
		
		return Objects.equals(nombre, other.nombre);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
}
