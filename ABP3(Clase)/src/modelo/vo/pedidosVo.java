package modelo.vo;

public class pedidosVo {
	
	private int codPed;
	private String fecha;
	private String enviado;
	private String Restaurante;
	public int getCodPed() {
		return codPed;
	}
	public void setCodPed(int codPed) {
		this.codPed = codPed;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEnviado() {
		return enviado;
	}
	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}
	public String getRestaurante() {
		return Restaurante;
	}
	public void setRestaurante(String restaurante) {
		Restaurante = restaurante;
	}

	public String toString() {
		return "PEDIDOS: Codigo Pedido: " + codPed + " | Fecha: " + fecha + " | Enviado: " + enviado + " | Restaurante: "
				+ Restaurante + " |";
	}
}
