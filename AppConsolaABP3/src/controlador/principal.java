package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.conexion.conexion;
import modelo.dao.categoriasDao;
import modelo.dao.productosDao;
import modelo.vo.categoriasVo;

public class principal {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		int menuElige1=0;
		boolean haConectado=false;
		
		System.out.println("Introduzca su nombre de usuario:");
		String login=in.nextLine();
		System.out.println("Introduzca su password");
		String password=in.nextLine();

			
		if(((login.equals("admin"))&&(password.equals("admin")))||(login.equals("root"))&&(password.equals("root"))) {
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
				case 2:
					ArrayList<categoriasVo> categorias=new ArrayList<categoriasVo>();
					int numCategorias=0;
					
					in.nextLine();
					
					System.out.println("Introduzca su nombre:");
					String nombreProducto=in.nextLine();
					
					System.out.println("Introduzca su descripcion:");
					String descripcionProducto=in.nextLine();
					
					System.out.println("Introduzca su peso:");
					while (in.hasNextDouble()==false) {
						System.out.println("Numero no valido. El formato incluye una coma: \n");
						in.next();
					}
					double pesoProducto=in.nextDouble();
					
					System.out.println("Introduzca su stock:");
					while (in.hasNextInt()==false) {
						System.out.println("Error. Introduzca un número:");
						in.next();
					}
					int stockProducto=in.nextInt();
					
					categorias=categoriasDao.mostrarTodasLasCategorias(categorias);
					
					for (int i=0; i<categorias.size(); i++) {
						System.out.println(categorias.get(i).getCodCat()+".- "+categorias.get(i).getNombre());
					}
					numCategorias++;
					System.out.println("Introduzca su categoria:");
					while (in.hasNextInt()==false) {
						System.out.println("Error. Introduzca un número:");
						in.next();
					}
					int categoriaProducto=in.nextInt();
					productosDao.registrarProducto(nombreProducto, descripcionProducto, pesoProducto, stockProducto, categoriaProducto);
					if (productosDao.categoriaExistente==false) {
						do {
							for (int i=0; i<categorias.size(); i++) {
								System.out.println(categorias.get(i).getCodCat()+".- "+categorias.get(i).getNombre());
							}
							System.out.println("Error. Ha introducido una categoria inexistente. Seleccione una existente:");
							while (in.hasNextInt()==false) {
								System.out.println("Error. Introduzca un número:");
								in.next();
							}
							categoriaProducto=in.nextInt();
							productosDao.registrarProducto(nombreProducto, descripcionProducto, pesoProducto, stockProducto, categoriaProducto);
						}while(productosDao.categoriaExistente==false);
					}
			}
				
			
		}while(menuElige1!=3);

	}
	
	public static void mostrarMenu1() {
		System.out.println("LOS POLLOS HERMANOS");
		System.out.println("1.- Insertar categoría");
		System.out.println("2.- Insertar producto");
		System.out.println("3.- Salir");
	}
}
