package controlador;

import vistas.ventanaLogin;
import vistas.ventanaCarrito;
import vistas.ventanaListaCategorias;
import vistas.ventanaProductosCategoria;
import vistas.ventanaCerrarSesion;
import java.util.ArrayList;
import modelo.logica;
import modelo.vo.categoriasVo;

public class coordinador {

	private ventanaLogin ventanaLogin; 
	private ventanaCarrito ventanaCarrito;
	private ventanaListaCategorias ventanaListaCategorias;
	private ventanaProductosCategoria ventanaProductosCategoria;
	private ventanaCerrarSesion ventanaCerrarSesion;
	
	private logica logica;
	
	//Ventana de login
	public void mostrarVentanaLogin() {
		ventanaLogin.setVisible(true);
	}
	public void ocultarVentanaLogin() {
		ventanaLogin.setVisible(false);
	}
	public void setVentanaLogin(ventanaLogin ventanaLogin) {
		this.ventanaLogin=ventanaLogin;
	}
	
	//Ventana del carrito
	public void mostrarVentanaCarrito() {
		ventanaCarrito.setVisible(true);
	}
	public void ocultarVentanaCarrito() {
		ventanaCarrito.setVisible(false);
	}
	
	public void setVentanaCarrito(ventanaCarrito ventanaCarrito) {
		this.ventanaCarrito=ventanaCarrito;
	}
	
	//Ventana listar categorias
	public void mostrarVentanaListaCategorias() {
		ventanaListaCategorias.setVisible(true);
	}
	public void ocultarVentanaListaCategorias() {
		ventanaListaCategorias.setVisible(false);
	}
	public void setVentanaListaCategorias(ventanaListaCategorias ventanaListaCategorias) {
		this.ventanaListaCategorias=ventanaListaCategorias;
	}
	
	//Ventana de productos de una categoria
	public void mostrarVentanaProductosCategoria() {
		ventanaProductosCategoria.setVisible(true);
	}
	public void ocultarVentanaProductosCategoria() {
		ventanaProductosCategoria.setVisible(false);
	}
	public void setVentanaProductosCategoria(ventanaProductosCategoria ventanaProductosCategoria) {
		this.ventanaProductosCategoria=ventanaProductosCategoria;
	}
	
	//Ventana de cerrar sesion
	public void mostrarVentanaCerrarSesion() {
		ventanaCerrarSesion.setVisible(true);
	}
	public void ocultarVentanaCerrarSesion() {
		ventanaCerrarSesion.setVisible(false);
	}
	public void setVentanaCerrarSesion(ventanaCerrarSesion ventanaCerrarSesion) {
		this.ventanaCerrarSesion=ventanaCerrarSesion;
	}
	
	//Parte logica
	public logica getLogica() {
		return logica;
	}
	public void setLogica(logica logica) {
		this.logica=logica;
	}
	
	public void mostrarCategorias(ArrayList<categoriasVo> categoria) {
		ventanaListaCategorias.mostrarCategorias(categoria);
	}
}
