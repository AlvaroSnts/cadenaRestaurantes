package modelo.dao;

import java.sql.CallableStatement;
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
			PreparedStatement prepState1 = conexionBD.conectarBD().prepareStatement("SELECT * FROM vista_lista_categorias");
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
		CallableStatement prepState2 = conexionBD.conectarBD().prepareCall("CALL mostrarCategoriaPorNombre(?);");
		
		prepState2.setString(1, ventanaListaCategorias.categoriaString);
		
		ResultSet res = prepState2.executeQuery();
		while(res.next()){
			existe=true;
			categoriasVo categoria= new categoriasVo();
			categoria.setCodCat(res.getInt("codCat"));
			categoria.setNombre(res.getString("nombre"));
			categoria.setDescripcion(res.getString("descripcion"));
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
public static String stringCaracteristicasCategorias(String nombreCategoria,int opcion) {
	conexion conexionBD= new conexion();
	String caracteristicasProducto="";
	try {
		PreparedStatement recogerStock = conexionBD.conectarBD().prepareStatement("SELECT * FROM lista_caracteristicas_categoria where nombre like ?");
		recogerStock.setString(1, nombreCategoria);
		ResultSet res = recogerStock.executeQuery();
		while(res.next()) {
			if(opcion==1) {
				if(res.getString("descripcion")==null) {
					caracteristicasProducto=caracteristicasProducto+" Descripcion: Sin descripcion especificada";
				}
				else
					caracteristicasProducto=caracteristicasProducto+" Descripcion: "+res.getString("descripcion");
			}
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return caracteristicasProducto;
}
}
