package controlador;

import vistas.ventanaCarrito;
import vistas.ventanaCerrarSesion;
import vistas.ventanaListaCategorias;
import vistas.ventanaLogin;
import vistas.ventanaProductosCategoria;

public class principal {
	
	static coordinador coordinador;

	static ventanaLogin login;
	static ventanaListaCategorias listaCategorias;
	static ventanaProductosCategoria productosCategoria;
	static ventanaCarrito carrito;
	static ventanaCerrarSesion cerrarSesion;
	
	public static void main(String[] args) {
		
		//Se instancian las clases
		coordinador=new coordinador();
		
		login=new ventanaLogin();
		listaCategorias=new ventanaListaCategorias();
		productosCategoria=new ventanaProductosCategoria();
		carrito=new ventanaCarrito();
		cerrarSesion=new ventanaCerrarSesion();
		
		//Relaciones entre clases
		login.setCoordinador(coordinador);
		carrito.setCoordinador(coordinador);
		listaCategorias.setCoordinador(coordinador);
		productosCategoria.setCoordinador(coordinador);
		cerrarSesion.setCoordinador(coordinador);
		
		//Relaciones con la clase coordinador
		coordinador.setVentanaLogin(login);
		coordinador.setVentanaListaCategorias(listaCategorias);
		coordinador.setVentanaProductosCategoria(productosCategoria);
		coordinador.setVentanaCarrito(carrito);
		coordinador.setVentanaCerrarSesion(cerrarSesion);	
	}

}
