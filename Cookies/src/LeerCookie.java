

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeerCookie
 */
@WebServlet("/LeerCookie")
public class LeerCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerCookie() {
        super();
        // TODO Auto-generated constructor stub
             
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 response.setContentType("text/html;charset=UTF-8"); 
	     PrintWriter out = response.getWriter(); 
		
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			/* al menos hay una cookie
			 * 
			 */
			for (int i=0;i<cookies.length;i++)
			{
		
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Datos de las cookies</title>");

				out.println("</head>");
				out.println("<body>");
				out.println("nombre Cookie: " +cookies[i].getName()); 
				out.println("Valor de la Cookie: " +cookies[i].getValue());	
				out.println("</body>");
				out.println("</html>");
			}
			
			
		}
		else
		{
			// no tiene cookies
			System.out.println("El cliente aun no tiene cookies");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
