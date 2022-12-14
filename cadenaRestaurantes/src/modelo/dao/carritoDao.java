package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;
import vistas.ventanaLogin;

public class carritoDao {
	public static void eliminarStockCarrito(List<Map.Entry<String ,Integer>> list) {
		conexion conexion = new conexion();
		Connection connection = conexion.conectarBD();
		int stockActual=0;
		if(list.size()>0) {
			try {
				connection.setAutoCommit(false);
				PreparedStatement quitarStock = conexion.conectarBD().prepareStatement("CALL updateProductos(?,?,?)");
				PreparedStatement conseguirStockActual = conexion.conectarBD().prepareStatement("Select stock from vista_stocks where nombre like ?");
				for(int i=0;i<list.size();i++) {
					conseguirStockActual.setString(1, list.get(i).getKey());
					ResultSet res= conseguirStockActual.executeQuery();
					while(res.next()) {
						stockActual=res.getInt("stock");
					}
					quitarStock.setInt(1, stockActual);
					quitarStock.setString(2, list.get(i).getKey());
					quitarStock.setInt(3, list.get(i).getValue());
					quitarStock.executeUpdate();
				}
				connection.commit();
				JOptionPane.showMessageDialog(null, "Se ha relizado el pedido","Pedido realizado",JOptionPane.INFORMATION_MESSAGE);
				connection.close();
			} catch (SQLException e1) {
	
				try {
					connection.rollback();
					JOptionPane.showMessageDialog(null, "No ha podido realizarse el pedido","Error",JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
					connection.close();
				} catch (SQLException e2) {
	
				}
			}
		}
	}
	public static String procesarPedido(List<Map.Entry<String ,Integer>> list) {
		conexion conexion = new conexion();
		Connection connection = conexion.conectarBD();
		LocalDateTime fechaActual = LocalDateTime.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String fechaConFormato = fechaActual.format(formatoFecha);
		if(list.size()>0) {
			try {
				connection.setAutoCommit(false);
				PreparedStatement realizarPedido = connection.prepareStatement("CALL realizarPedido(?,?)");
				realizarPedido.setString(1, fechaConFormato);
				realizarPedido.setInt(2, ventanaLogin.codigoRestaurante);
				realizarPedido.execute();
				connection.commit();
				connection.close();
				return fechaConFormato;
			} catch (Exception e) {
				try {
					connection.rollback();
					connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		else
			JOptionPane.showMessageDialog(null, "No se puede realizar el pedido si el carrito est?? vacio","Error",JOptionPane.ERROR_MESSAGE);
		return null;
		
	}
	public static void insertarPedidosProductos(String fecha,List<Map.Entry<String ,Integer>> list) {
		conexion conexion = new conexion();
		Connection connection = conexion.conectarBD();
		try {
			connection.setAutoCommit(false);
			int codPedido = 0;
			int codProducto = 0;
			PreparedStatement seleccionarCodPedido = connection.prepareStatement("SELECT codPed FROM vista_codPed_fecha_restaurante"
					+ " WHERE fecha LIKE ? and restaurante LIKE ?");
			seleccionarCodPedido.setString(1, fecha);
			seleccionarCodPedido.setInt(2, ventanaLogin.codigoRestaurante);
			ResultSet res = seleccionarCodPedido.executeQuery();
			while(res.next()) {
				codPedido=res.getInt("codPed");
			}
			for(int i=0;i<list.size();i++) {
				PreparedStatement seleccionarCodProducto = connection.prepareStatement("SELECT * FROM vista_nombres_producto WHERE nombre like ?");
				seleccionarCodProducto.setString(1, list.get(i).getKey());
				ResultSet res2 = seleccionarCodProducto.executeQuery();
				while(res2.next()) {
					codProducto=res2.getInt("codProd");
				}
				PreparedStatement anadirPedidosProductos = connection.prepareStatement("CALL anadirPedidosProductos(?,?,?)");
				anadirPedidosProductos.setInt(1, codPedido);
				anadirPedidosProductos.setInt(2, codProducto);
				anadirPedidosProductos.setInt(3, list.get(i).getValue());
				anadirPedidosProductos.executeUpdate();
				connection.commit();
			}
			connection.close();
		} catch (Exception e) {
			try {
				connection.rollback();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			e.printStackTrace();
		}
	}
}