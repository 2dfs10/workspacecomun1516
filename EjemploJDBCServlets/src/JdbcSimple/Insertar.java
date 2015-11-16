package JdbcSimple;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insertar
 */
@WebServlet("/Insertar")
public class Insertar extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// statement para ejecutar sentencia SQL

	private Statement sentencia;

	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {

			// Leer el driver específico de la base de datos que vamos a
			// utilizar, en nuestro caso, será:
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// Establecer la conexión, tenemos cargado el Driver y ahora
			// establecer la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tutorias", "root", "");

			// escribo la cadena SQL los campos se pueden recoger del formulario

			// String consulta = "INSERT INTO tutorias_t2
			// VALUES('"+alumno+"','"+profesor+"','"+dia+"','"+hora+"','"+asunto+"')";

			// null si tengo campo con autoincremento
			// String consulta = "INSERT INTO tutorias_t2
			// VALUES(null,'"+alumno+"','"+profesor+"','"+dia+"','"+hora+"','"+asunto+"')";

			String inserto = "INSERT INTO tutorias_t2 VALUES('Jose Zacarias','Rosa Maria','Lunes','10:00','Esto es ejemplo de tutopria')";

			// Creamos una sentencia a partir de la conexión

			sentencia = conexion.createStatement();
			
			//Ejecutamos la orden SQL
			
			 sentencia.executeUpdate(inserto);
			
			

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
