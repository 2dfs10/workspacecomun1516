package jdbcestructurado;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertarEstructurado
 */
@WebServlet("/InsertarEstructurado")
public class InsertarEstructurado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Creo la conexion y la sentencia
	private Conecta conexion= new Conecta();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarEstructurado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String insertodato = "INSERT INTO tutorias_t2 VALUES(null,'Jose Zacarias','Rosa Maria','Lunes','10:00','Esto es ejemplo de tutopria')";

		// Creamos una sentencia a partir de la conexión

		//sentencia = conexion.createStatement();
		 // sentencia.executeUpdate(consulta);
		
		//Ejecutamos la orden SQL
		
		try {
			conexion.getSentencia().executeUpdate(insertodato);
		 
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
