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
 * Servlet implementation class CrearUnaSession
 */
@WebServlet("/CrearUnaSession")
public class CrearUnaSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearUnaSession() {
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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String atributo = "Sesion1";
		String atributo2 = "Sesion2";
		String valor = "Primera";
		String valor2 = "SEGUNDO";
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet que muestra el contenido de la sesion</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>El contenido de tu sesion es:</h1>");
		// Obtenemos sesion , creamos una si fuera necesario

		HttpSession sesionCli = request.getSession();
		// vamos a visualizar y asignar los valores de una sesión creada por un
		// usuario.

		String idSesion = sesionCli.getId();
		long fechaCreacion = sesionCli.getCreationTime();
		long fechaUltimoAcceso = sesionCli.getLastAccessedTime();

		// vamos a poner un valor a la sesión
		sesionCli.setAttribute(atributo, valor);

		out.println("<h2>Datos de la Sesión :</h2>");
		out.println("Sesión :" + idSesion + "<br>");
		out.println("Fecha de Creación de la Sesión :"
				+ (new Date(fechaCreacion)).toString() + "<br>");
		out.println("Fecha del último acceso :"
				+ (new Date(fechaUltimoAcceso)).toString() + "<br>");
		// vamos a visualizar sus atributos , se recogen en un Enumerado

		Enumeration nombresParametros = sesionCli.getAttributeNames();
		String parametro = (String) nombresParametros.nextElement();
		Object dato = sesionCli.getAttribute(parametro);

		//out.println("Sesión " + parametro + " Valor " + dato + "<br>");
		/*
			Enumeration nombresParametros = sesionCli.getAttributeNames(); while
		 (nombresParametros.hasMoreElements()) { String param = (String)
		  nombresParametros.nextElement(); Object valor2 =
		  sesionCli.getAttribute(param); out.println("Sesión...." + param +
		  " Valor.... " + valor2 + "<br>");
		  */
		  }
		 
		//out.println("</body>");
		//out.println("</html>");
		// cerramos el flujo
		//out.close();

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
