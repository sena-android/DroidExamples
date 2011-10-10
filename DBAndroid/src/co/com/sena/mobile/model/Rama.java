package co.com.sena.mobile.model;

import java.util.List;

public class Rama {
	
	private String nombre;
	private List<Ambiente> ambientes;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Ambiente> getAmbientes() {
		return ambientes;
	}
	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

}
