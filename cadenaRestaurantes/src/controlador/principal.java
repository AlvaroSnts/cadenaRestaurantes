package controlador;

import vistas.ventanaCarrito;
import vistas.ventanaListaCategorias;
import vistas.ventanaLogin;
import vistas.ventanaProductosCategoria;
import modelo.logica;

public class principal {
	
	static logica logica;
	static coordinador coordinador;

	static ventanaLogin login;
	static ventanaListaCategorias listaCategorias;
	static ventanaProductosCategoria productosCategoria;
	static ventanaCarrito carrito;
	
	public static void main(String[] args) {
		
		//Se instancian las clases
		coordinador=new coordinador();
		logica=new logica();
		
		login=new ventanaLogin();
		listaCategorias=new ventanaListaCategorias();
		productosCategoria=new ventanaProductosCategoria();
		carrito=new ventanaCarrito();
		
		//Relaciones entre clases
		login.setCoordinador(coordinador);
		carrito.setCoordinador(coordinador);
		listaCategorias.setCoordinador(coordinador);
		productosCategoria.setCoordinador(coordinador);
		
		//Relaciones con la clase coordinador
		coordinador.setVentanaLogin(login);
		coordinador.setVentanaListaCategorias(listaCategorias);
		coordinador.setVentanaProductosCategoria(productosCategoria);
		coordinador.setVentanaCarrito(carrito);
		
		coordinador.setLogica(logica);
		logica.setCoordinador(coordinador);
		
	}

}
