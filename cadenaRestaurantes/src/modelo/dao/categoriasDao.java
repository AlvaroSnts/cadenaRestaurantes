package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.conexion;

import modelo.vo.categoriasVo;
import vistas.ventanaListaCategorias;

public class categoriasDao {

	
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

public static ArrayList<categoriasVo> mostrarCategoriaPorNombre(ArrayList<categoriasVo> categorias){
	
	conexion conexionBD= new conexion();
	
	boolean existe=false;
	try {
		PreparedStatement prepState2 = conexionBD.conectarBD().prepareStatement("SELECT * FROM categorias WHERE nombre='"+ventanaListaCategorias.categoriaString+"';");
		ResultSet res = prepState2.executeQuery();
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
