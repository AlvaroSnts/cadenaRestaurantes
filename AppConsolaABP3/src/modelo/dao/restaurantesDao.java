package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.conexion.conexion;
import modelo.vo.categoriasVo;
import modelo.vo.productosVo;


public class restaurantesDao {

	public void insertarCategoria(categoriasVo categoria) {
		conexion conexionBD= new conexion();
		
		try {
			PreparedStatement prepaState1 = conexionBD.conectarBD().prepareStatement("INSERT INTO categorias VALUES ('"+categoria.getCodCat()+"'"
					+ ", '"+categoria.getNombre()+"', '"+categoria.getDescripcion()+"');");
			System.out.println("Datos anadidos correctamente.");
			prepaState1.close();
			conexionBD.desconectarBD();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
            System.out.println("Error. No se ha podido insertar el restaurante.");
		}
	}
	
	public void insertarProducto(productosVo producto) {
		conexion conexionBD= new conexion();
		
		try {
			Statement estatuto = conexionBD.conectarBD().createStatement();
			
			System.out.println("Datos añadidos correctamente.");
			estatuto.close();
			conexionBD.desconectarBD();
			
		}catch(SQLException e) {
			
		}
	}
}
