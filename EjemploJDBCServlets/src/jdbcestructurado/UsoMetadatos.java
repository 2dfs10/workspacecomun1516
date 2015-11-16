package jdbcestructurado;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsoMetadatos
 */
@WebServlet("/UsoMetadatos")
public class UsoMetadatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion = new Conecta();
	ResultSet resultados = null; // objeto para guardar los resultados

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsoMetadatos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	 

		// ejecutamos orden
		try {
			String consulta = "select * From tutorias_t2";
			resultados = conexion.getSentencia().executeQuery(consulta);

			// Ver estructura de la tabla y tipo 
			
			ResultSetMetaData infoResultados = resultados.getMetaData();

			int col = infoResultados.getColumnCount();

			out.println("Estructura de la tabla Tutorias: ");
			out.println("<br>");
			for (int i = 1; i <= col; i++) {
				out.println("Atributo : " + infoResultados.getColumnLabel(i) + "\t" + "Tipo: "
						+ infoResultados.getColumnTypeName(i));
				out.println("<br>");

			}
			
			while (resultados.next()) {
				for (int i = 1; i <= col; i++)
				out.print(resultados.getString(i) + "\t");
				out.println("<br>");
				}
			
		 // consulta de los datos sin conocer los campos
			
			
			
			
			
			
			
			

		} catch (Exception e) {
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
