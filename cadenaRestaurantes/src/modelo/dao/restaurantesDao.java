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
	public static ArrayList<restaurantesVo> verTodosLosCodRestaurante(ArrayList<restaurantesVo> restaurantes) {
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			PreparedStatement prepState1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM vista_ver_restaurantes");
			ResultSet res = prepState1.executeQuery();
			while(res.next()){
				existe=true;
				restaurantesVo restaurante= new restaurantesVo();
				restaurante.setCodRes(res.getInt("codRes"));
				restaurante.setClave(res.getString("clave"));
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
