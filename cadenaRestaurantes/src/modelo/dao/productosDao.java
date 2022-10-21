package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.conexion.conexion;
import modelo.vo.productosVo;

public class productosDao {
	public static String mostrarTodosLosProductosCateCategoria() {
		String productos = "";
		conexion conexionBD = new conexion();
		productosVo productosVo = new productosVo();
		try {
			PreparedStatement preparedStatement1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM productos");
			ResultSet res = preparedStatement1.executeQuery();
			while(res.next()) {
				if(productosVo.getCategoria()==1) {
					productos=productos+"Nombre Producto: "+productosVo.getNombre();
					System.out.println("Hola");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		};
		return productos;
	}
}
