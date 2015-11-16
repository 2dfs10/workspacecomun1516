
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Creo la sesión.
		HttpSession sesionCli = request.getSession();

		Vector v = new Vector();
		v.addElement(new String("Lunes"));
		v.addElement(new String("Martes"));
		v.addElement(new String("Miércoles"));

		sesionCli.setAttribute("dias de la semana ", v);

		// recojo valores sesion
		Enumeration sesion = sesionCli.getAttributeNames();

/*		String nombresesio = (String) sesion.nextElement();
		Vector Valor = (Vector) sesionCli.getAttribute(nombresesio);*/

		/*out.println("Mi nombre sesion es  " + nombresesio);
		out.println("<br>");*/

		//out.println("El valor del Object es " + Valor);
		
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
