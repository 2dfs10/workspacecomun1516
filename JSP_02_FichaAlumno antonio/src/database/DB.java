package database;
import java.sql.*;

public class DB {
	private MySQLConnection conn;
	private Statement stm;
	
	/** Method for INSERT, UPDATE & DELETE Statements*/
	public boolean modify(String sql) {
		try {
			conn = new MySQLConnection();
			stm = conn.getConnection().createStatement();
			stm.executeUpdate(sql);
//			close();
		} 
		catch (SQLException e) {
            System.out.println(e.getMessage());
			return false;
		}
		catch (NullPointerException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	/** Method for SELECT Statements */
	public ResultSet query(String sql) {
		ResultSet results;
		
		try {
			conn = new MySQLConnection();
			stm = conn.getConnection().createStatement();
			results = stm.executeQuery(sql);
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		catch (NullPointerException e) {
			System.out.println(e);
			return null;
		}
		
		return results;
	}
	
	public void close() {
		try {
			stm.close();
			conn.disconnect();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println(e);
		}
	}
	
//	/** Extraer datos del ResultSet */
//	DB db = new DB();
//	String sql = "SELECT * FROM tabla;";
//	ResultSet results = db.query(sql);
//
//	// Si no falla la consulta (por sintaxis, error de conexion...)
//	if (results != null) {
//		// Si results contiene al menos una fila y el puntero está delante de la primera fila
//		if (results.isBeforeFirst()) {
//			while (results.next()) {
//				int campo1 = results.getInt("campo1");
//				String campo2 = results.getString("campo2");
//			}
//		}
//		else {
//		// results está vacío 
//		}
//	}
//	else {
//		// mostrar mensaje de error por fallo en la consulta (sintaxis, error de conexion)
//	}
//	db.close();
	
}
