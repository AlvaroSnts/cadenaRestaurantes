package modelo.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
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
	public static conexion conexionBD ;
	public static Connection connection ;
	public static ArrayList<productosVo> mostrarTodosLosProductosCategoria(ArrayList<productosVo> productos){
		boolean existe=false;
		try {
			conexionBD= new conexion();
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
	public static int comprobarStock(String nombreProducto) {
		conexionBD= new conexion();
		int cantidadStock=0;
		try {
			PreparedStatement recogerStock = conexionBD.conectarBD().prepareStatement("SELECT stock FROM vista_stocks where nombre like ?");
			recogerStock.setString(1, nombreProducto);
			ResultSet res = recogerStock.executeQuery();
			while(res.next()){
				cantidadStock=res.getInt(1);
			}
			res.close();
			conexionBD.desconectarBD();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return cantidadStock;
	}

	public static String stringCaracteristicasProducto(String nombreProducto,int opcion) {
		conexionBD= new conexion();
		String caracteristicasProducto="";
		try {
			PreparedStatement recogerStock = conexionBD.conectarBD().prepareStatement("SELECT * FROM lista_caracteristicas_producto where nombre like ?");
			recogerStock.setString(1, nombreProducto);
			ResultSet res = recogerStock.executeQuery();
			while(res.next()) {
				if(opcion==1) {
					caracteristicasProducto=caracteristicasProducto+" Nombre: "+res.getString("nombre");
				}
				if(opcion==2) {
					if(res.getString("descripcion")==null) {
						caracteristicasProducto=caracteristicasProducto+" Descripcion: Sin descripcion especificada";
					}
					else
					caracteristicasProducto=caracteristicasProducto+" Descripcion: "+res.getString("descripcion");
				}
				if(opcion==3) {
					if(res.getString("peso")==null) {
						caracteristicasProducto=caracteristicasProducto+" Descripcion: Sin peso especificado";
					}
					else
					caracteristicasProducto=caracteristicasProducto+" Peso: "+res.getString("peso");

				}
				if(opcion==4) {
				caracteristicasProducto=caracteristicasProducto+" Stock: "+res.getString("stock");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return caracteristicasProducto;
	}
}
