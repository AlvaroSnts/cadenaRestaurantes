package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.conexion.conexion;

import modelo.vo.categoriasVo;
import vistas.ventanaListaCategorias;

public class categoriasDao {

	
public ArrayList<categoriasVo> mostrarTodasLasCategorias(ArrayList<categoriasVo> categorias){
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			Statement estatuto = conexionBD.conectarBD().createStatement();
			ResultSet res = estatuto.executeQuery("SELECT * FROM categorias");
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

public ArrayList<categoriasVo> mostrarCategoriaPorNombre(ArrayList<categoriasVo> categorias){
	
	conexion conexionBD= new conexion();
	
	boolean existe=false;
	try {
		Statement estatuto = conexionBD.conectarBD().createStatement();
		ResultSet res = estatuto.executeQuery("SELECT * FROM categorias WHERE nombre='"+ventanaListaCategorias.categoriaString+"';");
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
}
