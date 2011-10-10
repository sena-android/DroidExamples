package co.com.sena.mobile.model;

import java.util.List;

public class SedeSena {
	
	private String direccion;
	private String nombre;
	private Persona director;
	private List<Rama> ramas; 
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Persona getDirector() {
		return director;
	}
	public void setDirector(Persona director) {
		this.director = director;
	}
	public List<Rama> getRamas() {
		return ramas;
	}
	public void setRamas(List<Rama> ramas) {
		this.ramas = ramas;
	}


}
