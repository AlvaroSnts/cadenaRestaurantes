package modelo.vo;

public class restaurantesVo {
	
	private int codRes;
	private String correo;
	private int clave;
	private String pais;
	private int cp;
	private String ciudad;
	private String direccion;
	
	
	public int getCodRes() {
		return codRes;
	}
	public void setCodRes(int codRes) {
		this.codRes = codRes;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString() {
		return "RESTAURANTE:  Codigo de restaurante: " + codRes + " | Correo: " + correo + " | Clave: " + clave + " | Pais: " + pais
				+ " | Correo Postal: " + cp + " | Ciudad: " + ciudad + " | Direccion: " + direccion + " |";
	}
	
	
}
