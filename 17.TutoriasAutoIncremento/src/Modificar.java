import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
       
   
    public Modificar() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String hora = request.getParameter("hora");
		String id = request.getParameter("id");
		String mensaje = "";
		
				String consulta = "UPDATE tutorias_t2 SET hora='"+hora+"' WHERE id='"+id+"'";
				try {
					if(conexion.getSentencia().executeUpdate(consulta) != 0) {
					conexion.getSentencia().executeUpdate(consulta);
					mensaje = "<table border='1' id='mitabla'><tr><td>Tutoría modificada con éxito!!!</td></tr></table>";	
					
					}
					else {
						mensaje = "<table border='1' id='mitabla'><tr><td>Tutoría no existe!!!</td></tr></table>";	
					}
				
					//Construye pagina
					out.println("<html>");
					out.println("<head>");
					out.println("<Title>Modificar hora tutoria</title>");
					out.println("<link rel='stylesheet' href='estilo.css' type='text/css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div id='cabecera'><h1>Modificar tutoria</h1>");
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
