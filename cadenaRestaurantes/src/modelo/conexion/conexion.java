package modelo.conexion;

import java.sql.*;

public class conexion {
	   static String bd = "cadenaRestaurante";
	   private static String login;
	   private static String password;
	   static String url = "jdbc:mysql://localhost/"+bd;

	   Connection conn = null;

	   public conexion() {
	      try{

	         conn = DriverManager.getConnection(url,login,password);

	         if (conn!=null){
	            System.out.println("La conexion a "+bd+" se ha realizado con exito.");
	         }
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
