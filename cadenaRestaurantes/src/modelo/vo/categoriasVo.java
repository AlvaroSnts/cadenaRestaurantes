package modelo.vo;

public class categoriasVo {
	private int codCat;
	private String nombre;
	private String descripcion;
	public int getCodCat() {
		return codCat;
	}
	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
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
