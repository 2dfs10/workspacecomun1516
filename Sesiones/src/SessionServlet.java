// Servlet que muestra los atributos y valores en una sesión. También puede invalidarla
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
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nuevoAtributo = request.getParameter("parametro");
		String valor = request.getParameter("valor");
		String action = request.getParameter("accion");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet que muestra el contenido de la sesion</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>El contenido de tu sesion es:</h1>");
		HttpSession s = request.getSession();

		if (action.equals("invalidar")) {
			s.invalidate();
			out.println("<h1>Sesion invalidada:</h1>");
		} else {
			s.setAttribute(nuevoAtributo, valor);
			out.println("<ul>");
			/*
			Enumeration<String> nombresDeAtributos = s.getAttributeNames();

			while (nombresDeAtributos.hasMoreElements()) {
				String atributo = nombresDeAtributos.nextElement();
				out.println("<li><b>" + atributo + ": </b>"
						+ s.getAttribute(atributo) + "</li>");
			}
			out.println("</ul>");
			*/
		}
		out.println("<a href=sesion2.html> Volver a la página anterior"
				+ "</a><br/>");

		// out.println(request.getQueryString());

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
