package modelo.conexion;

import java.sql.*;

public class conexion {
	   static String bd = "cadenaRestaurantes";
	   private static String login="restaurante";
	   private static String password="restaurante";
	   static String url = "jdbc:mysql://localhost/"+bd;

	   Connection conn = null;

	   public conexion() {
	      try{
	         conn = DriverManager.getConnection(url,login,password);
	      }
	      catch(SQLException e){
	         System.out.println(e);

	      }catch(Exception e){
	         System.out.println(e);
	      }
	   }

	   public Connection conectarBD(){
	      return conn;
	   }

	   public void desconectarBD(){
	      conn = null;
	   }
	   
	   public static void setLogin(String login) {
		   conexion.login=login;
	   }
	   
	   public static void setPassword(String password) {
		   conexion.password=password;
	   }
	}
