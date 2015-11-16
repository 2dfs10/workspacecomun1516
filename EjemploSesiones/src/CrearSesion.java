
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class CrearSesion
 */
@WebServlet("/CrearSesion")
public class CrearSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Creo sesion
		
		HttpSession sesionCli = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		// Voy a crear un par de atributos con sus valores, parecido a lo que son las cookies
		
		String nombre1 = "Curso";
		String valor1 = "2daw";
		String nombre2 ="asignatura";
		String valor2 ="dwes";
		
		String nombre3 = "Hora";
		String valor3 = "12:30";
		
		String nombre4 = "Profesor";
		String valor4 = "Miguel";
		
		
		sesionCli.setAttribute(nombre1, valor1);
		sesionCli.setAttribute(nombre2, valor2);
		sesionCli.setAttribute(nombre3, valor3);
		sesionCli.setAttribute(nombre4, valor4);
		
		
		// Ahora vamos a recoger y visualizar los valores de los atributos creados en la sesion
		
		Enumeration recogesesion = sesionCli.getAttributeNames();
		
		
		while (recogesesion.hasMoreElements())
		{
			String nombresesion =  (String) recogesesion.nextElement();		
			String valorsesion = (String) sesionCli.getAttribute(nombresesion);
			out.println("<br>");
			out.println("<br>");
			out.println("El nombre del atributo es "+nombresesion);
			out.println("<br>");
			out.println("<br>");
			out.println("El valor del atributo es "+valorsesion);
			
		}
		
		
		
		// Voy a utilizar algunos métodos implícitos de una sesión
		
		
		
		out.println("<br>");	
		out.println("<br>");
	String idsesion = sesionCli.getId();
	out.println("El valor Id de la sesion es "+idsesion);
		long horacreacion = sesionCli.getCreationTime();
		
		out.println("<br>");	
		out.println("<br>");
		
		out.println("La hora de Creación de la sesión es "+horacreacion);
		out.println("<br>");	
		out.println("<br>");
		out.println("La hora de Creación de la sesión es "+new Date (horacreacion));
		
		long ultimoacceso=sesionCli.getLastAccessedTime();
		out.println("<br>");	
		out.println("<br>");
		
		out.println("La hora del último acceso es "+new Date (ultimoacceso));
		
		long tiempoconexion = ultimoacceso - horacreacion;
		out.println("<br>");	
		out.println("<br>");
		
		out.println("El tiempo conectado en la sesión es "+ (tiempoconexion/1000));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
