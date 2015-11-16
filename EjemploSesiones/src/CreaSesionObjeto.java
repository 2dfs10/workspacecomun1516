

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreaSesionObjeto
 */
@WebServlet("/CreaSesionObjeto")
public class CreaSesionObjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaSesionObjeto() {
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
		
		Empleado v1 = new Empleado();
		Empleado v2 = new Empleado();
		
	// voy a asignar valores al objeto
		
		v1.setNombre("Juanito");
		v1.setTelefono(1234);
		
		v2.setNombre("Andresito ");
		v2.setTelefono(9999999);
		
		
		// defino variable de sesion
		
		HttpSession sesionCli = request.getSession();
		
		// pongo nombre al atributo y le asigno el valor de un objeto
		
		sesionCli.setAttribute("nombre Objeto1", v1);
		
		sesionCli.setAttribute("nombre Objeto 2 ", v2);
		
		
		// ahora recogemos los valores del atributo
		
		Enumeration sesion = sesionCli.getAttributeNames();
		
		while (sesion.hasMoreElements())
			
		{
			
			String nombreatributo = (String) sesion.nextElement();
			
			Empleado vemple = (Empleado) sesionCli.getAttribute(nombreatributo);
			
			out.println("El nombre de atributo de la sesion es "+nombreatributo);
			out.println("<br>");
			out.println("<br>");
			out.println("los valores del objeto son: "+ vemple.getNombre()+" teléfono "+vemple.getTelefono());
			
			out.println("<br>");
			out.println("<br>");
			
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
