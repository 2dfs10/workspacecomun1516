import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Borrar")
public class Borrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
       
    
    public Borrar() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String mensaje = "";

				String consulta = "DELETE FROM tutorias_t2 WHERE id=('"+id+"')";
		
				
				try {
					if(conexion.getSentencia().executeUpdate(consulta) != 0) {
					conexion.getSentencia().executeUpdate(consulta);
					
					mensaje = "<table border='1' id='mitabla'><tr><td>Tutoria " + id + " borrada con éxito!!!</td></tr></table>";
					}
					else {
						
						mensaje = "<table border='1' id='mitabla'><tr><td>Tutoría no existe!!!</td></tr></table>";
						
					}
					
					//Construye pagina
					out.println("<html>");
					out.println("<head>");
					out.println("<Title>Insertar tutorias</title>");
					out.println("<link rel='stylesheet' href='estilo.css' type='text/css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div id='cabecera'><h1>Borrar tutoria</h1>");
				  	out.println("</div>");
				  	out.println(mensaje);
				  	out.println("<a href='formulario0.html' style='position:absolute;top:500px;left:650px;'>Volver</a>");
					
					out.println("</body>");
					out.println("</html>");
					response.setHeader("Refresh", "2;URL=http://localhost:8080/17.TutoriasAutoIncremento/formulario0.html");
					//Fin construye pagina
						  	
						
				
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
