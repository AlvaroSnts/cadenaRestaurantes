package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.categoriasVo;
import modelo.vo.productosVo;
import modelo.vo.restaurantesVo;


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
	public static ArrayList<restaurantesVo> verTodosLosCodRestaurante(ArrayList<restaurantesVo> restaurantes) {
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			PreparedStatement prepState1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM restaurantes");
			ResultSet res = prepState1.executeQuery();
			while(res.next()){
				existe=true;
				restaurantesVo restaurante= new restaurantesVo();
				restaurante.setCodRes(res.getInt("codRes"));
				restaurantes.add(restaurante);
			 }
			res.close();
			conexionBD.desconectarBD();
								
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se ha podido conectar");
			System.out.println(e);
		}
		
		if (existe) {
			return restaurantes;
		}
		else return null;
	}
}
