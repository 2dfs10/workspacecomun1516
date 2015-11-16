import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conecta {
	private final String controlador = "com.mysql.jdbc.Driver";
	private final String db = "jdbc:mysql://127.0.0.1:3306/tutorias";
	private final String usuario = "root";
	private final String contraseña = "";
	private Connection conexion;
	private Statement sentencia;
	
	public Conecta() {
		
		
		try {
			Class.forName(controlador).newInstance();
			conexion = DriverManager.getConnection(db, usuario, contraseña);
			sentencia = conexion.createStatement();
			System.out.println("Conexión realizada con éxito");
			
			
		} catch (InstantiationException e) { //excepcion de linea 1 del tray(instancia)
			System.out.println("Objeto no creado..." + e.getMessage());
			e.printStackTrace();
			
		} catch (IllegalAccessException e) { //excepcion de linea 1 del tray(instancia)
			System.out.println("Acceso ilegal a la base de datos..." + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) { //excepcion de linea 1 del tray(instancia)
			System.out.println("No se ha podido cargar el controlador..." + e.getMessage());
			e.printStackTrace();
			
		} catch (SQLException e) { //excepcion de linea 2 del tray(conexion)
			System.out.println("Excepcion SQL..." + e.getMessage());
		}
		
		
	}
	
	public Statement getSentencia()
	{
		return sentencia;
	}

}

