package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import modelo.conexion.conexion;

public class carritoDao {
	public static void eliminarStockCarrito(List<Map.Entry<String ,Integer>> list) {
		conexion conexion = new conexion();
		Connection connection = conexion.conectarBD();
		int stockActual=0;
		try {
			connection.setAutoCommit(false);
			PreparedStatement quitarStock = conexion.conectarBD().prepareStatement("UPDATE productos set stock = (? - ?) where nombre like ?");
			PreparedStatement conseguirStockActual = conexion.conectarBD().prepareStatement("Select stock from productos where nombre like ?");
			for(int i=0;i<list.size();i++) {
				conseguirStockActual.setString(1, list.get(i).getKey());
				ResultSet res= conseguirStockActual.executeQuery();
				while(res.next()) {
					stockActual=res.getInt("stock");
				}
				quitarStock.setInt(1, stockActual);
				quitarStock.setString(3, list.get(i).getKey());
				quitarStock.setInt(2, list.get(i).getValue());
				quitarStock.executeUpdate();
			}
			connection.commit();
			JOptionPane.showMessageDialog(null, "Se ha relizado el pedido","Pedido realizado",JOptionPane.INFORMATION_MESSAGE);
			connection.close();
		} catch (SQLException e1) {
			try {
				connection.rollback();
				JOptionPane.showMessageDialog(null, "No ha podido realizarse el pedido","Error",JOptionPane.ERROR_MESSAGE);
				connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e1.printStackTrace();
		}
	}

}
