package modelo.vo;

public class productosVo {

	private int codProd;
	private String nombre;
	private String descripcion;
	private double peso;
	private int stock;
	private int categoria;
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String toString() {
		return "PRODUCTO: Codigo Producto: " + codProd + " | Nombre: " + nombre + " | Descripcion: " + descripcion + " | Peso: "
				+ peso + " | Stock: " + stock + " | Categoria: " + categoria + " |";
	}
}
