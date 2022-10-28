package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.conexion;

import modelo.vo.categoriasVo;


public class categoriasDao {
	
	public static conexion conexionBD ;
	public static Connection connection ;

	public static void registrarCategoria(String nombre, String descripcion) {
		
		conexionBD=new conexion();
		connection=conexionBD.conectarBD();
		
		try {
			connection.setAutoCommit(false);
			PreparedStatement estatuto=conexionBD.conectarBD().prepareStatement
					("INSERT INTO categorias(nombre, descripcion) VALUES ('"+nombre+"', '"+descripcion+"');");
			estatuto.execute();
		}catch(SQLException e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<categoriasVo> mostrarTodasLasCategorias(ArrayList<categoriasVo> categorias){
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			PreparedStatement prepState1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM categorias");
			ResultSet res = prepState1.executeQuery();
			while(res.next()){
				existe=true;
				categoriasVo categoria= new categoriasVo();
				categoria.setCodCat(res.getInt("codCat"));
				categoria.setNombre(res.getString("nombre"));
				categorias.add(categoria);
			 }
			res.close();
			conexionBD.desconectarBD();
								
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error, no se ha podido conectar");
			System.out.println(e);
		}
		
		if (existe) {
			return categorias;
		}
		else return null;				
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
