

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CuentaPagina2
 */
@WebServlet("/CuentaPagina2")
public class CuentaPagina2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer objCuenta2 = 1; // contador
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CuentaPagina2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Necesario para visualizar los datos por el navegador
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Primero, obtenemos las cookies del cliente
		Cookie[] cookie = request.getCookies(); // arreglo de cookies

		// recogemos el valor de la cookie
		// String cuenta = null;
		synchronized (this) {
			if (cookie == null) // no hay cookies obtenidos del getCookies
			{
			 
				Cookie cookie2 = new Cookie("cuenta.ck", objCuenta2.toString());
				cookie2.setMaxAge(5); // 1 hora
				response.addCookie(cookie2);
			} else {
				cookie = request.getCookies();
				objCuenta2++;
				Cookie cookie2 = new Cookie("cuenta.ck", objCuenta2.toString());
				cookie2.setMaxAge(5); // 1 hora
				response.addCookie(cookie2);
			}
		}
		
		out.println("<html>");
		out.println("Has visitado la página " + objCuenta2);
		out.println("</html>");

		// Cerrar el flujo
		out.close();
 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
