package modelo.vo;

public class pedidosProductosVo {

	private int codPedProd;
	private int pedido;
	private int producto;
	private int unidades;
	public int getCodPedProd() {
		return codPedProd;
	}
	public int getPedido() {
		return pedido;
	}
	public int getProducto() {
		return producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setCodPedProd(int nuevoCod) {
		codPedProd=nuevoCod;
	}
	public void setPedido(int nuevoPedido) {
		pedido=nuevoPedido;
	}
	public void setProducto(int nuevoProducto) {
		producto=nuevoProducto;
	}
	public void setUnidades(int nuevasUnidades) {
		unidades=nuevasUnidades;
	}
	public String toString() {
		return "Categorias: Codigo de PedidoProducto: "+codPedProd
				+", Pedido:"+pedido+", Producto:"+producto+", Unidades:"+unidades;
	}
}
