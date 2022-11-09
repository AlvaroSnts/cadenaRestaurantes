package modelo.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.conexion;

import modelo.vo.categoriasVo;


public class categoriasDao {
	

	public static void registrarCategoria(String nombre, String descripcion) {
		
		conexion conexionBD=new conexion();
		
		try {
			CallableStatement estatuto=conexionBD.conectarBD().prepareCall("CALL registrarCategoria(?, ?);");
			estatuto.setString(1, nombre);
			estatuto.setString(2, descripcion);
			estatuto.executeQuery();
		}catch(SQLException e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<categoriasVo> mostrarTodasLasCategorias(ArrayList<categoriasVo> categorias){
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			PreparedStatement prepState1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM vista_mostrar_categorias");
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
}
