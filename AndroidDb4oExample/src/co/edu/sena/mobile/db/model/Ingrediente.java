package co.edu.sena.mobile.db.model;

public class Ingrediente {

	private String nombre;
	private Long codigo;
	private String unidadDeMedida;
	private int cantidad;
	
	
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
	public String getUnidadDeMedida() {
		return unidadDeMedida;
	}
	public void setUnidadDeMedida(String unidadDeMedida) {
		this.unidadDeMedida = unidadDeMedida;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
