package modelo.dao;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.productosVo;
import vistas.ventanaListaCategorias;

public class productosDao {

	public static ArrayList<productosVo> mostrarTodosLosProductosCategoria(ArrayList<productosVo> productos){
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			CallableStatement prepState2 = conexionBD.conectarBD().prepareCall("CALL mostrarTodosLosProductosCategoria(?);");
			
			prepState2.setInt(1, ventanaListaCategorias.categoriaInt);
			
			ResultSet res = prepState2.executeQuery();
			while(res.next()){
				existe=true;
				productosVo producto= new productosVo();
				producto.setCodProd(res.getInt("codProd"));
				producto.setNombre(res.getString("nombre"));
				producto.setDescripcion(res.getString("descripcion"));
				producto.setPeso(res.getDouble("peso"));
				producto.setStock(res.getInt("stock"));
				producto.setCategoria(res.getInt("categoria"));
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
