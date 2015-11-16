

import java.io.*;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreoSesion
 */
@WebServlet({ "/CreoSesion", "/Sesion" })
public class CreoSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreoSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		// cojo los datos de la sesión.
		HttpSession sesionCli = request.getSession();
		String atributo = "Atributo 1";
		String valor = "Primera sesion";
		String atributo2 = "Atributo 2";
		String valor2 = "Segundo valor del atributo 2";
		
		// ahora deseo ver los atributos de HtttpSession
		
		String idSesion = sesionCli.getId();
		long FechaCreacion = sesionCli.getCreationTime();
		long FechaUltimoAcceso = sesionCli.getLastAccessedTime();
		sesionCli.setAttribute(atributo,valor);
		sesionCli.setAttribute(atributo2,valor2);
		
		// Ahora preparo la salida de datos HTML
		out.println("<html>");
		out.println("<body>");
		out.println("Datos de la Sesion de Usuario");
		out.println("<br>");
		out.println("Mi ID de sesion es "+idSesion);
		out.println("<br>");
		out.println("La creacion de mi sesión es "+ (new Date(FechaCreacion)));
		out.println("<br>");
		out.println("Mi último acceso es "+ new Date(FechaUltimoAcceso));
		out.println("<br>");
		
		Enumeration  nombresesion = sesionCli.getAttributeNames();
		
		
		 String nombresesio = (String) nombresesion.nextElement();
		 Object ValorSesion = sesionCli.getAttribute(nombresesio);
		 
		
		while (nombresesion.hasMoreElements())
		
		{
			//String nombresesio = (String) nombresesion.nextElement();
			
			//Object ValorSesion = sesionCli.getAttribute(nombresesio);
			
			out.println("Mi nombre sesion es  "+nombresesio);
			out.println("<br>");
			out.println("El valor del Object es "+ValorSesion);
			 nombresesio = (String) nombresesion.nextElement();
			 ValorSesion = sesionCli.getAttribute(nombresesio);
		}
		
		
		out.println("Mi nombre sesion es  "+nombresesio);
		out.println("<br>");
		out.println("El valor del Object es "+ValorSesion);
		
		// String nombresesio = (String) nombresesion.nextElement();
		// Object ValorSesion = sesionCli.getAttribute(nombresesio);
		//out.println("Mi nombre sesion es...  "+nombresesio);
		//out.println("<br>");
		// out.println("El valor del Object es... "+ValorSesion);
		
		

		out.println("</body>");
		out.print("</html>");
		out.close();

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
