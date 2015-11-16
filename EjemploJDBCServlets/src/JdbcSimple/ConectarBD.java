package JdbcSimple;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConectarBD
 */
@WebServlet("/ConectarBD")
public class ConectarBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

/*	private final String controlador = "com.mysql.jdbc.Driver";
	private final String db = "jdbc:mysql://127.0.0.1:3306/tutorias";
	private final String usuario = "root";
	private final String contraseña = "";*/
		
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConectarBD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {

			// Leer el driver específico de la base de datos que vamos a utilizar, en nuestro caso, será:
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Establecer la conexión, tenemos cargado el Driver y ahora establecer la conexion
			Connection conexion =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/tutorias", "root", "");
			out.println("Conexión realizada con éxito");
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Conexión realizada sin éxito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
