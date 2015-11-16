

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String nombreNuevaCookie = request.getParameter("cookie");
		String valor = request.getParameter("valor");
		int duracion;
		
		duracion = Integer.parseInt(request.getParameter("duracion"));
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet que muestra cookies</title>");
		out.println("</head>");
		out.println("<body>");
		
		
		if (nombreNuevaCookie != null && valor != null	&& !nombreNuevaCookie.equals("")) {
			Cookie nuevaCookie = new Cookie(nombreNuevaCookie, valor);
			nuevaCookie.setMaxAge(duracion);
			response.addCookie(nuevaCookie);
				}
		
		
	
		Cookie[] todasLasCookies = request.getCookies();
		if (todasLasCookies != null) {
			for (Cookie cookie : todasLasCookies) {
				out.println("<li><b>" + cookie.getName() + ":</b>"
						+ cookie.getValue() + "-, fecha de expiracion: "
						+ cookie.getMaxAge() + "</li>");
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
