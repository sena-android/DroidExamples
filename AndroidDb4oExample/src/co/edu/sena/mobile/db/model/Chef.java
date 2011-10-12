package co.edu.sena.mobile.db.model;

import java.util.List;

public class Chef {
	
	private String nombre;
	private String restaurante;
	private List<Receta> recetas;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public List<Receta> getRecetas() {
		return recetas;
	}
	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
	
	public String toString(){
		
		return "Nombre :"+nombre+" Restaurante "+restaurante;
	}

}
