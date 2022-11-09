package modelo.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.productosVo;


public class productosDao {

	public static boolean categoriaExistente=false;
	public static conexion conexionBD ;
	public static Connection connection ;
	
	public static void registrarProducto(String nombre, String descripcion, double peso, int stock, int categoria) {
		
		conexion conexionBD=new conexion();

		try {
			CallableStatement prepState2 = conexionBD.conectarBD().prepareCall("CALL registrarProducto(?, ?, ?, ?, ?);");
			prepState2.setString(1, nombre);
			prepState2.setString(2, descripcion);
			prepState2.setDouble(3, peso);
			prepState2.setInt(4, stock);
			prepState2.setInt(5, categoria);
			prepState2.executeQuery();
			categoriaExistente=true;
		}catch(SQLException e) {
			categoriaExistente=false;
			
		}
	}
	
	
	public static ArrayList<productosVo> mostrarNombresDeProducto(ArrayList<productosVo> productos) {
		
		conexionBD= new conexion();
		boolean existe=false;
		try {
			PreparedStatement prepState1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM vista_nombres_producto");
			ResultSet res = prepState1.executeQuery();
			while(res.next()){
				existe=true;
				productosVo producto= new productosVo();
				producto.setNombre(res.getString("nombre"));
				productos.add(producto);
			 }
			res.close();
			conexionBD.desconectarBD();
								
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se ha podido conectar");
			System.out.println(e);
		}
		
		if (existe) {
			return productos;
		}
		else return null;				
	}
}
