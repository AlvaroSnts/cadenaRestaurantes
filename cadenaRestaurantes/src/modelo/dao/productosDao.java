package modelo.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import modelo.vo.productosVo;
import vistas.ventanaListaCategorias;

public class productosDao {

	public ArrayList<productosVo> mostrarTodosLosProductosCategoria(ArrayList<productosVo> productos){
		
		conexion conexionBD= new conexion();
		
		boolean existe=false;
		try {
			Statement estatuto = conexionBD.conectarBD().createStatement();
			ResultSet res = estatuto.executeQuery("SELECT * FROM productos WHERE categoria='"+ventanaListaCategorias.categoriaInt+"';");
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
