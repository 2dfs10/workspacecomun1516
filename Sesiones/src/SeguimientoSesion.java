// Cuenta Pagina con Sesiones además de mas atributos

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
 * Servlet implementation class SeguimientoSesion
 */
@WebServlet("/SeguimientoSesion")
public class SeguimientoSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeguimientoSesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Tipo de la respuesta que será enviada al cliente
		response.setContentType("text/html");
		// Obtener el objeto 'PrintWriter' para devolver la respuesta
		PrintWriter out = response.getWriter();

		// Obtener la sesión actual; crear una si fuera necesario.
		HttpSession sesionCli = request.getSession(true);
		// Datos de la sesión
		String idSesion = sesionCli.getId();

		long fechaCreacion = sesionCli.getCreationTime();
		long fechaUltimoAcceso = sesionCli.getLastAccessedTime();

		// Incrementar el contador para esta página. El valor es
		// guardado en la sesión del cliente con el nombre "cuenta.ss".
		Integer cuenta = (Integer) sesionCli.getAttribute("cuenta.ss");
		if (cuenta == null)
			cuenta = new Integer(1);
		else
			cuenta = new Integer(cuenta.intValue() + 1);
		sesionCli.setAttribute("cuenta.ss", cuenta);

		out.println("<html>");
		out.println("<head><title>Seguimiento de sesión</title></head>");
		out.println("<body>");
		out.println("<h1>Demostración de seguimiento de una sesión</h1>");

		// Visualizar la cuenta para esta página
		out.println("Has visitado esta página " + cuenta
				+ ((cuenta.intValue() == 1) ? " vez." : " veces."));
		out.println("<p>");
		out.println("<h2>Datos de tu sesión:</h2>");
		out.println("Sesión: " + idSesion);
		out.println("<br>Fue creada: " + (new Date(fechaCreacion)).toString());
		out.println("<br>Fue accedida por última vez: "
				+ (new Date(fechaUltimoAcceso)).toString());
		out.println("<br>Atributos:<br>");
		Enumeration nombresParams = sesionCli.getAttributeNames();
		while (nombresParams.hasMoreElements()) {
			String param = (String) nombresParams.nextElement();
			Object valor = sesionCli.getAttribute(param);
			out.println(param + ": " + valor.toString() + "<br>");
		}
		out.println("</body>");
		out.println("</html>");

		// Cerrar el flujo
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
