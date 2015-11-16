package paquete1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class acumular
 */
@WebServlet("/acumular")
public class acumular extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Producto productoc = new Producto();
	private Integer SumaValor = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public acumular() {
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
		// response.getWriter().append("en acumular
		// ").append(request.getContextPath());

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Creo la sesión.
		HttpSession sesionCli = request.getSession();

		String nombrelibro = request.getParameter("libro");

		String dato = request.getParameter("comprar");

		// dato puede tomar los valores "Comprar Libro" o "Finalizar Compra"

		if (dato.equals("Comprar Libro")) {
			// aculuma los libros

			switch (nombrelibro) {

			case "Java":

				productoc.nombrep.add(nombrelibro);
				productoc.precio.add(10);
				SumaValor = SumaValor + 10;

				out.println("el libro comprado es " + nombrelibro + " valor  10");
				break;

			case "C":

				productoc.nombrep.add(nombrelibro);
				productoc.precio.add(20);
				SumaValor = SumaValor + 20;
				out.println("el libro comprado es " + nombrelibro + " valor  20");
				break;

			case "MySQL":

				productoc.nombrep.add(nombrelibro);
				productoc.precio.add(30);
				SumaValor = SumaValor + 30;
				out.println("el libro comprado es " + nombrelibro + " valor  30");
				break;

			case "JavaScript":

				productoc.nombrep.add(nombrelibro);
				productoc.precio.add(40);
				SumaValor = SumaValor + 40;
				out.println("el libro comprado es " + nombrelibro + " valor  40");
				break;

			}

			sesionCli.setAttribute("librosesion", productoc);
			response.setHeader("Refresh", "2;URL=libros.html");

		} else {
			// totaliza los libros comprados

			// recojo valores sesion
			Enumeration sesion = sesionCli.getAttributeNames();

			while (sesion.hasMoreElements())

			{
				String nombresesio = (String) sesion.nextElement();
				Producto Valor = (Producto) sesionCli.getAttribute(nombresesio);
				out.println("Mi nombre sesion es  " + nombresesio);
				out.println("<br>");
				out.println("<br>");

				for (int j = 0; j < Valor.nombrep.size(); j++) {
					out.println("El nombre del libro es " + Valor.nombrep.get(j) + " " + " cuyo precio es "
							+ Valor.precio.get(j));
					out.println("<br>");
					out.println("<br>");
				}
				out.println("La suma total es " + SumaValor);

			}
			// invalido sesion para empezar del principio y borro los objetos

			productoc = null;
			productoc = new Producto();
			SumaValor = 0;
			sesionCli.invalidate();

			response.setHeader("Refresh", "5;URL=libros.html");

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
