package co.edu.sena.mobile.db.model;

import java.util.List;

public class Receta {
	
	private String nombre;
	private Long codigo;
	private String pais;
	private String autor;
	private List<Ingrediente> ingredientes;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
