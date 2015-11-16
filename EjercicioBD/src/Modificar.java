

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Statement ordensql;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Leer el driver especifico de la B.Datos , nuestro caso es MySQL
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Tengo que establecer la conexion una vez cargado el driver
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorias","root","");
			
			// meto la orden en un String

			//
			// UPDATE `tutorias_t2` SET dia='Viernes' WHERE alumno = 'ivan'
			
String modificar = "UPDATE `tutorias_t2` SET dia='Prueba' WHERE alumno = 'ivan'";

			ordensql = conexion.createStatement();
			
			ordensql.executeUpdate(modificar);
			
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			
			response.getWriter().append("Conexión Fallida en el insert !!!!!").append(request.getContextPath());
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
