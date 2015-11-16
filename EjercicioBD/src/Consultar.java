

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Consultar
 */
@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Statement ordensql; 
	 private ResultSet resultados;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Leer el driver especifico de la B.Datos , nuestro caso es MySQL
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					
					// Tengo que establecer la conexion una vez cargado el driver
					
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorias","root","");
					
					
					
					
					String consulta = "SELECT * FROM `tutorias_t2`";
					
					ordensql = conexion.createStatement();
					
					resultados = ordensql.executeQuery(consulta);
					
					resultados.first();
					
				while (	resultados.next())
				{
					
					out.println(" Nombre Alumno: "+resultados.getString("alumno"));
					out.println("<br>");
					out.println(" Nombre Profesor: "+resultados.getString("profesor"));
					out.println("<br>");
					out.println(" Día: "+resultados.getString("dia"));
					out.println("<br>");
					out.println(" Hora  "+resultados.getString("hora"));
					out.println("<br>");
					out.println(" Asunto "+resultados.getString("asunto"));
					out.println("<br>");
					out.println("<br>");
						
					
					
				}
					
				
			
					
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					
					response.getWriter().append("Conexión Fallida !!!!!").append(request.getContextPath());
					
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
