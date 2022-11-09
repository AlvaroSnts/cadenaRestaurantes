package controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.conexion.conexion;
import modelo.dao.categoriasDao;
import modelo.dao.productosDao;
import modelo.vo.categoriasVo;
import modelo.vo.productosVo;

public class principal {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int menuElige1=0;
		int eligeAceptar=0;
		boolean haConectado=false;
		
		System.out.println("Introduzca su nombre de usuario:");
		String login=in.nextLine();
		System.out.println("Introduzca su password");
		String password=in.nextLine();

			
		if((login.equals("administrador"))&&(password.equals("administrador"))) {
			conexion.setLogin(login);
			conexion.setPassword(password);
		}else {
			do {
				System.out.println("Error en la introduccion de datos. Introduzca su nombre de usuario:");
				login=in.nextLine();
				System.out.println("Introduzca su password");
				password=in.nextLine();

					
				if(((login.equals("admin"))&&(password.equals("admin")))||(login.equals("root"))&&(password.equals("root"))) {
					haConectado=true;
					conexion.setLogin(login);
					conexion.setPassword(password);
				}
			}while(haConectado==false);
		}
		
		do {
			mostrarMenu1();
			while (in.hasNextInt()==false) {
				System.out.println("\n Tecla no válida. Introduce un número del 1 al 3: \n");
				mostrarMenu1();
				in.next();
			}
			menuElige1=in.nextInt();
			if ((menuElige1<1)||(menuElige1>3)) {
				do {
					System.out.println("Posición no válida. Elija otra:");
					while (in.hasNextInt()==false) {
						System.out.println("Tecla no válida. Seleccione un número del 1 al 3:");
						in.next();
					}
					menuElige1=in.nextInt();
				} while ((menuElige1<1)&&(menuElige1>3));
			}
			
			switch(menuElige1) {
				case 1:
					in.nextLine();
					System.out.println("Introduzca el nombre de la categoria:");
					String nombreCategoria=in.nextLine();
					System.out.println("Introduzca su descripcion:");
					String descripcionCategoria=in.nextLine();
					categoriasDao.registrarCategoria(nombreCategoria, descripcionCategoria);
					
					break;
				case 2:
					ArrayList<categoriasVo> categorias=new ArrayList<categoriasVo>();
					ArrayList<productosVo> productos=new ArrayList<productosVo>();
					boolean nombreIgual=false;
					int numCategorias=0;
					String nombreProducto="";
					in.nextLine();
					
					//Primero el nombre. Comprueba que no se repita con otro y que se introduzca algo.
					do {
						nombreIgual=false;
						System.out.println("Introduzca su nombre:");
						nombreProducto=in.nextLine();
						
						productos=productosDao.mostrarNombresDeProducto(productos);
						
						for (int i=0; i<productos.size(); i++) {
							if (productos.get(i)!=null) {
								if (productos.get(i).getNombre().equals(nombreProducto)) {
									nombreIgual=true;
								}
							}
						}
						if (nombreIgual==true) {
							System.out.println("Error. Ya hay un producto con ese nombre. Introduzca otro nombre:");
						}
						if (nombreProducto.equals("")) {
							nombreIgual=true;
							System.out.println("Error. No ha introducido ningún nombre. Introduzca uno: ");
						}
					}while(nombreIgual==true);
					
					System.out.println("Introduzca su descripcion:");
					String descripcionProducto=in.nextLine();
					
					System.out.println("Introduzca su peso:");
					while (in.hasNextDouble()==false) {
						System.out.println("Numero no valido. El formato incluye una coma: \n");
						in.next();
					}
					double pesoProducto=in.nextDouble();
					
					String stockString="";
					in.nextLine();
					do {
						System.out.println("Introduzca su stock:");
						stockString=in.nextLine();
						
						if (comprobarStock(stockString)==false) {
							System.out.println("Error. Debes escribir un número.");
						}
					}while(comprobarStock(stockString)==false);
					
					int stockProducto=Integer.parseInt(stockString);
					
					categorias=categoriasDao.mostrarTodasLasCategorias(categorias);
					
					for (int i=0; i<categorias.size(); i++) {
						System.out.println(categorias.get(i).getCodCat()+".- "+categorias.get(i).getNombre());
					}
						
					String cat="";
					do {
						System.out.println("Introduzca su categoría:");
						cat=in.nextLine();
						
						if (comprobarStock(cat)==false) {
							System.out.println("Error. Debes escribir un número.");
						}
					}while(comprobarCategoriaInt(cat)==false);
					
					int categoriaProducto=Integer.parseInt(cat);
					
					productosDao.registrarProducto(nombreProducto, descripcionProducto, pesoProducto, stockProducto, categoriaProducto);
					
					break;
			}
		}while(menuElige1!=3);

	}
	
	public static void mostrarMenu1() {
		System.out.println("LOS POLLOS HERMANOS");
		System.out.println("1.- Insertar categoría");
		System.out.println("2.- Insertar producto");
		System.out.println("3.- Salir");
	}
	
	public static boolean comprobarStock(String stock) {
		if (stock.equals("")||(stock.equals(" "))) {
			return false;
		}
		for (int i=0; i<stock.length(); i++) {
			if (((int)stock.charAt(i)<48)||((int)stock.charAt(i)>57)) {
				return false;
			}
		}
		return true;
	}
	public static boolean comprobarCategoriaInt(String stock) {
		if (stock.equals("")||(stock.equals(" "))) {
			return false;
		}
		for (int i=0; i<stock.length(); i++) {
			if (((int)stock.charAt(i)<48)||((int)stock.charAt(i)>57)) {
				return false;
			}
		}
		return true;
	}
}
