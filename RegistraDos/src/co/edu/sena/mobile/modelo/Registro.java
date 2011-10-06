package co.edu.sena.mobile.modelo;

import java.util.Date;

public class Registro {

		private String documento;
		private String tipoUsuario;
		private String entrada;
		private String urlImagePortatil;
		private String urlImagePropietario;
		private String urlImageQR;
		private Date fechaIngreso;
		private Date fechaSalida;

	

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public String getTipoUsuario() {
			return tipoUsuario;
		}

		public void setTipoUsuario(String tipoUsuario) {
			this.tipoUsuario = tipoUsuario;
		}

		public String getEntrada() {
			return entrada;
		}

		public void setEntrada(String entrada) {
			this.entrada = entrada;
		}

		public String getUrlImagePortatil() {
			return urlImagePortatil;
		}

		public void setUrlImagePortatil(String urlImagePortatil) {
			this.urlImagePortatil = urlImagePortatil;
		}

		public String getUrlImagePropietario() {
			return urlImagePropietario;
		}

		public void setUrlImagePropietario(String urlImagePropietario) {
			this.urlImagePropietario = urlImagePropietario;
		}

		public String getUrlImageQR() {
			return urlImageQR;
		}

		public void setUrlImageQR(String urlImageQR) {
			this.urlImageQR = urlImageQR;
		}

		public Date getFechaIngreso() {
			return fechaIngreso;
		}

		public void setFechaIngreso(Date fechaIngreso) {
			this.fechaIngreso = fechaIngreso;
		}

		public Date getFechaSalida() {
			return fechaSalida;
		}

		public void setFechaSalida(Date fechaSalida) {
			this.fechaSalida = fechaSalida;
		}

		
		public String toString(){
			return "Registro "+documento+"--" +tipoUsuario+"--"+ entrada+"--"+fechaIngreso+"--";
		
			
			
		}
		
		
	
	

}
