import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ConsultaConcreta")
public class ConsultaConcreta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
	ResultSet resultados = null; // objeto para guardar los resultados
       
   
    public ConsultaConcreta() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		response.setContentType("text/html");
		String mensaje = "";
		
		String consulta = "SELECT id,alumno,profesor,dia,hora,asunto FROM tutorias_t2 WHERE id='"+id+"'";

		
		try {
			resultados = conexion.getSentencia().executeQuery(consulta);
			
			if (resultados.isBeforeFirst()) {
				
				while(resultados.next()) {
			  
				//mensaje += "<form method='get' action='http://localhost:8080/17.TutoriasAutoIncremento/ConsultaConcreta' name='formulario'>";
				mensaje += "<table border='1' id='mitabla'>";
				mensaje += "<tr>";
				mensaje += "<th>ID</th>";
				mensaje += "<th>Alumno</th>";
				mensaje += "<th>Profesor</th>";
				mensaje += "<th>Dia</th>";
				mensaje += "<th>Hora</th>";
				mensaje += "<th>Asunto</th>";
				mensaje += "</tr>";
				mensaje += "<tbody>";
			
				mensaje += "<tr><td>" + resultados.getString("id") + "</td><td>" + resultados.getString("alumno") + "</td><td>" + resultados.getString("profesor") + "</td><td>" + resultados.getString("dia") + "</td><td>" + resultados.getString("hora") + "</td><td>" + resultados.getString("asunto") + "</td></tr>";
				}
				mensaje += "</tbody>";
				mensaje += "</table>";
				//mensaje += "</form>";
	
				
			}
			else
			{
			mensaje = "<table border='1' id='mitabla'><tr><td>Tutoría no existe!!!</td></tr></table>";	
			response.setHeader("Refresh", "2;URL=http://localhost:8080/17.TutoriasAutoIncremento/formulario0.html");
			}
			
			//Construye pagina
			out.println("<html>");
			out.println("<head>");
			out.println("<Title>Consulta Concreta</title>");
			out.println("<link rel='stylesheet' href='estilo.css' type='text/css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div id='cabecera'><h1>Consultar tutoria</h1>");
		  	out.println("</div>");
		  	out.println(mensaje);
		  	out.println("<a href='formulario0.html' style='position:absolute;top:500px;left:650px;'>Volver</a>");
			out.println("<div id='pie'><p>Copyright © 2013 Felicia Perez. Todos los derechos reservados.</p></div>");
			out.println("</body>");
			out.println("</html>");
			//Fin construye pagina
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
