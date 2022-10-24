package modelo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.productosVo;


public class productosDao {

	public static boolean categoriaExistente=false;
	
	public static void registrarProducto(String nombre, String descripcion, double peso, int stock, int categoria) {
		
		conexion conexionBD=new conexion();
		
		try {
			PreparedStatement estatuto=conexionBD.conectarBD().prepareStatement
					("INSERT INTO productos(nombre, descripcion, peso, stock, categoria) VALUES ('"+nombre+"', '"+descripcion+"', "+peso+", "+stock+", "+categoria+");");
			estatuto.execute();
			System.out.println("Datos añadidos correctamente.");
			categoriaExistente=true;
			estatuto.close();
			conexionBD.desconectarBD();
		}catch(SQLException e) {
			categoriaExistente=false;
		}
	}
}
