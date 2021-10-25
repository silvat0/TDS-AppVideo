package modelo;

public class Usuario {
	//Atributos
	private String nombre;
	private String email; 
	private boolean premium;
	
	//Constructor
	private Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email = email;
		this.premium = false;
	}

	//Getters
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	//Metodos
	private void setPremium() {
		premium = !premium;
	}
}
