

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CrearSesionObjeto3
 */
@WebServlet("/CrearSesionObjeto3")
public class CrearSesionObjeto3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearSesionObjeto3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Creo la sesión.
		HttpSession sesionCli = request.getSession();

		Vector v1 = new Vector();
		Vector v2 = new Vector();
		
		v1.addElement(new String("Lunes"));
		v1.addElement(new String("Martes"));
		v1.addElement(new String("Miércoles"));
		v1.addElement(new String("Jueves"));
		v1.addElement(new String("Viernes"));

		v2.addElement(new String("Sábado"));
		v2.addElement(new String("Domingo"));
		
		sesionCli.setAttribute("dias de la semana ", v1);
		sesionCli.setAttribute("Fines de semana ", v2);

		// recojo valores sesion
		Enumeration sesion = sesionCli.getAttributeNames();

 
		
		while (sesion.hasMoreElements())

		{
		 String nombresesio = (String) sesion.nextElement();
		 Vector	 Valor = (Vector) sesionCli.getAttribute(nombresesio);
			out.println("Mi nombre sesion es  " + nombresesio);
			out.println("<br>");
			out.println("<br>");
			for (int j=0;j<Valor.size();j++)
			{
				out.println("El valor del Object  es " + Valor.get(j)+" ");
			out.println("<br>");
			out.println("<br>");
			}	
			
		 
			
			
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
