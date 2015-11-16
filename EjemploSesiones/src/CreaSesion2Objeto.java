
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
 * Servlet implementation class CreaSesion2Objeto
 */
@WebServlet("/CreaSesion2Objeto")
public class CreaSesion2Objeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreaSesion2Objeto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		NumReal NumRe = new NumReal();
		NumReal NumRe2 = new NumReal();

		NumRe.setReal(8);
		NumRe.setImaginaria(2);
		NumRe2.setReal(16);
		NumRe2.setImaginaria(26);

		// Creo la sesión.
		HttpSession sesionCli = request.getSession();

		//
		sesionCli.setAttribute("Numero Real ", NumRe);
		sesionCli.setAttribute("Numero Real2 ", NumRe2);

		// recojo valores sesion
		Enumeration sesion = sesionCli.getAttributeNames();

		while (sesion.hasMoreElements())

		{
			String nombresesio = (String) sesion.nextElement();
			NumReal Valor = (NumReal) sesionCli.getAttribute(nombresesio);
			out.println("Mi nombre sesion es  " + nombresesio);
			out.println("<br>");
			out.println("<br>");
			out.println("El valor del Object real es " + Valor.getReal());
			out.println("<br>");
			out.println("<br>");
			out.println("El valor del Object imaginaria es " + Valor.getImaginaria());

			out.println("<br>");
			out.println("<br>");
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
