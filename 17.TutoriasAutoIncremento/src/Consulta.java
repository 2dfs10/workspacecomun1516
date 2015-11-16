import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Consulta")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
	ResultSet resultados = null; // objeto para guardar los resultados
       
    
    public Consulta() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String consulta = "select * from tutorias_t2";
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<Title>Consulta de tutorias</title>");
		out.println("<link rel='stylesheet' href='estilo.css' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		
		try {

			  	out.println("<div id='cabecera'><h1>Consulta de Tutorias</h1>");
			  	out.println("</div>");
				out.println("<form method='get' action='http://localhost:8080/17.TutoriasAutoIncremento/Consulta' name='formulario'>");
				out.println("<table border='1' id='mitabla'>");
				out.println("<tr>");
				out.println("<th>Id</th>");
				out.println("<th>Alumno</th>");
				out.println("<th>Profesor</th>");
				out.println("<th>Dia</th>");
				out.println("<th>Hora</th>");
				out.println("<th>Asunto</th>");
				out.println("</tr>");
				out.println("<tbody>");
				
				resultados = conexion.getSentencia().executeQuery(consulta);
				
				while(resultados.next()){
					
				out.println("<tr><td>" + resultados.getString("id") +"</td><td>" + resultados.getString("alumno") + "</td><td>" + resultados.getString("profesor") + "</td><td>" + resultados.getString("dia") + "</td><td>" + resultados.getString("hora") + "</td><td>" + resultados.getString("asunto") + "</td></tr>");
				}
				out.println("</tbody>");
				out.println("</table>");
				out.println("</form>");
				out.println("<a href='formulario0.html' style='position:absolute;top:500px;left:650px;'>Volver</a>");
			
				out.println("</body>");
				out.println("</html>");
				
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
