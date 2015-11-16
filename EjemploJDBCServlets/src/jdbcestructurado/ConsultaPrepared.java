package jdbcestructurado;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultaPrepared
 */
@WebServlet("/ConsultaPrepared")
public class ConsultaPrepared extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion = new Conecta();
	ResultSet resultados = null; // objeto para guardar los resultados
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPrepared() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String consulta = "select * From tutorias_t2";
		PreparedStatement ps= null;
		
		
		try {
		ps = conexion.getSentencia().getConnection().prepareStatement(consulta);
		
		// ejecutamos orden
	
			resultados = conexion.getSentencia().executeQuery(consulta);
		
			if (resultados.isBeforeFirst()) {

				// hay algun record

				while (resultados.next()) {
					out.println(" alumno " + resultados.getString("alumno"));
					out.println("<br>");
					out.println(" profesor " + resultados.getString("profesor"));
					out.println("<br>");
					out.println(" dia " + resultados.getString("dia"));
					out.println("<br>");
					out.println(" hora " + resultados.getString("hora"));
					out.println("<br>");
					out.println(" asunto " + resultados.getString("asunto"));
					out.println("<br>");
					out.println("<br>");
					out.println("<br>");

				}
			} else {

				out.println("no hay ningún record");
			}

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
