package jdbcestructurado;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarEstructurado
 */
@WebServlet("/ModificarEstructurado")
public class ModificarEstructurado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Creo la conexion y la sentencia
			private Conecta conexion= new Conecta();     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarEstructurado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String modificar = "update tutorias_t2 set hora ='12:00'  where alumno = ('Jose Zacarias')";
		
		try {
			conexion.getSentencia().executeUpdate(modificar);
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
