package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.categoriasVo;

public class categoriasDao {

	
	public ArrayList<categoriasVo> listarCategorias(ArrayList<categoriasVo> categorias) {
		
		conexion conexion=new conexion();
		boolean existe=false;
		try {
			Statement estatuto = conexion.conectarBD().createStatement();
			ResultSet res = estatuto.executeQuery("SELECT * FROM categorias");
			while(res.next()){
				existe=true;
				categoriasVo categoria= new categoriasVo();
				categoria.setNombre(res.getString("categoria"));
				
				categorias.add(categoria);
			 }
			res.close();
			conexion.desconectarBD();
								
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
