package controlador;

import vistas.ventanaLogin;
import vistas.ventanaCarrito;
import vistas.ventanaListaCategorias;
import vistas.ventanaProductosCategoria;
import modelo.logica;

public class coordinador {

	private ventanaLogin ventanaLogin; 
	private ventanaCarrito ventanaCarrito;
	private ventanaListaCategorias ventanaListaCategorias;
	private ventanaProductosCategoria ventanaProductosCategoria;
	
	private logica logica;
	
	//Ventana de login
	public void mostrarVentanaLogin() {
		ventanaLogin.setVisible(true);
	}
	public void setVentanaLogin(ventanaLogin ventanaLogin) {
		this.ventanaLogin=ventanaLogin;
	}
	
	//Ventana del carrito
	public void mostrarVentanaCarrito() {
		ventanaCarrito.setVisible(true);
	}
	public void setVentanaCarrito(ventanaCarrito ventanaCarrito) {
		this.ventanaCarrito=ventanaCarrito;
	}
	
	//Ventana listar categorias
	public void mostrarVentanaListaCategorias() {
		ventanaListaCategorias.setVisible(true);
	}
	public void setVentanaListaCategorias(ventanaListaCategorias ventanaListaCategorias) {
		this.ventanaListaCategorias=ventanaListaCategorias;
	}
	
	//Ventana de productos de una categoria
	public void mostrarVentanaProductosCategoria() {
		ventanaProductosCategoria.setVisible(true);
	}
	public void setVentanaProductosCategoria(ventanaProductosCategoria ventanaProductosCategoria) {
		this.ventanaProductosCategoria=ventanaProductosCategoria;
	}
	
	
	//Parte logica
	public logica getLogica() {
		return logica;
	}
	public void setLogica(logica logica) {
		this.logica=logica;
	}
}
