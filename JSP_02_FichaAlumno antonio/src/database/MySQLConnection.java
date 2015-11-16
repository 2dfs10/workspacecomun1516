package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String PATH = "jdbc:mysql://localhost:3306/";
	private final String DATABASE = "dwes_fichaalumno";
	private final String USER = "root";
	private final String PASSWORD = "";
	private Connection connection;
	
	public MySQLConnection() {
		String url = PATH + DATABASE;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(url, USER, PASSWORD);
			
			if (connection != null)
				System.out.println("Conexion establecida con la base de datos.");
			else
				System.out.println("ERROR: Conexion nula.");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("ERROR: Driver de la base de datos no encontrado.");
			e.printStackTrace();
		} 
		catch (ExceptionInInitializerError e) {
			System.out.println("ERROR: Driver de la base de datos no inicializado.");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("ERROR: Fallo al conectar con la base de datos.");
			e.printStackTrace();
		} 
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		connection = null;
		System.out.println("Desconexión de la base de datos.");
	}
	
}
