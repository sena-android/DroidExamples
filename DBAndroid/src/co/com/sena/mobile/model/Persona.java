package co.com.sena.mobile.model;

import java.util.Date;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String cedula;
	private Date fechaNacimiento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public String toString(){
		
		return "nombre: "+nombre+" apellido: "+apellido+ " cedula: "+cedula;
	}

}
