import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Insertar")
public class Insertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();

       
   
    public Insertar() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String alumno = request.getParameter("alumno");
		String profesor = request.getParameter("profesor");
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String asunto = request.getParameter("asunto");
		String mensaje = "";
		
		
		
				String consulta = "INSERT INTO tutorias_t2 VALUES(null,'"+alumno+"','"+profesor+"','"+dia+"','"+hora+"','"+asunto+"')";
				
				try {
					
					if(alumno!=null && profesor != null && dia!= null && hora !=null && asunto != null) {
					conexion.getSentencia().executeUpdate(consulta);
					mensaje = "<table border='1' id='mitabla'><tr><td>Tutoria insertada con exito!!!</td></tr></table>";	
			
					} else {
						mensaje = "<table border='1' id='mitabla'><tr><td>Valores Incorrectos!!!</td></tr></table>";
					}
					
					//Construye pagina
					out.println("<html>");
					out.println("<head>");
					out.println("<Title>Insertar tutorias</title>");
					out.println("<link rel='stylesheet' href='estilo.css' type='text/css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("<div id='cabecera'><h1>Añadir tutoria</h1>");
				  	out.println("</div>");
				  	out.println(mensaje);
				  	out.println("<a href='formulario0.html' style='position:absolute;top:500px;left:650px;'>Volver</a>");
					out.println("<div id='pie'><p>Copyright © 2013 Felicia Perez. Todos los derechos reservados.</p></div>");
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
