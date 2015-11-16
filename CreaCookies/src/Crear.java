

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Crear
 */
@WebServlet("/Crear")
public class Crear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Crear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cookie c = new Cookie("user","rperez");
		Cookie c2 = new Cookie("nombre","pepe");
		
		c.setMaxAge(60*60);
		
		response.addCookie(c);
		response.addCookie(c2);
		
		// Lectura de las cookies
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie[] recogecookies = request.getCookies();
		
		
		for (int i=0; i<recogecookies.length; i++)
		{
			
			out.println (" El nombre de la cookie es " +recogecookies[i].getName());
			out.println ("<br>");
			out.println("El valor de la Cookie es " + recogecookies[i].getValue());
			out.println ("<br>");
			out.println ("<br>");
			out.println ("<br>");
			
			
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
