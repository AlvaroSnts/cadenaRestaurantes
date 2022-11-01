package modelo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.categoriasVo;
import modelo.vo.productosVo;


public class productosDao {

	public static boolean categoriaExistente=false;
	public static conexion conexionBD ;
	public static Connection connection ;
	
	public static void registrarProducto(String nombre, String descripcion, double peso, int stock, int categoria) {
		
		conexionBD=new conexion();
		connection=conexionBD.conectarBD();
		
		try {
			connection.setAutoCommit(false);
			PreparedStatement estatuto=conexionBD.conectarBD().prepareStatement
					("INSERT INTO productos(nombre, descripcion, peso, stock, categoria) VALUES ('"+nombre+"', '"+descripcion+"', "+peso+", "+stock+", "+categoria+");");
			estatuto.execute();
			categoriaExistente=true;
		}catch(SQLException e) {
			categoriaExistente=false;
		}
	}
	
	public static Connection getConnection() {
		return connection;
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
