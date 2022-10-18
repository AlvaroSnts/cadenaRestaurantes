package modelo.vo;

public class categoriasVo {
	private int codCat;
	private int nombre;
	private String descripcion;
	public int getCodCat() {
		return codCat;
	}
	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
		return "Categorias: Codigo de categoria: "+codCat
				+", Nombre:"+nombre+", Descripcion:"+descripcion;
	}
}	
