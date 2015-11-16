package jdbcestructurado;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorrarEstructurado
 */
@WebServlet("/BorrarEstructurado")
public class BorrarEstructurado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Creo la conexion y la sentencia
		private Conecta conexion= new Conecta(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarEstructurado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String borrar = "delete FROM tutorias_t2 where alumno = ('Jose Zacarias')";
		
		try {
			conexion.getSentencia().executeUpdate(borrar);
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
