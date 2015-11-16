

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Prueba1
 */
@WebServlet(
		urlPatterns = { 
				"/Prueba1", 
				"/Mapeo"
		}, 
		initParams = { 
				@WebInitParam(name = "name", value = "Gomez", description = "Guarda el apellido del alumno")
		})
public class Prueba1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private String vname; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		vname=config.getInitParameter("name");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 
		   response.setContentType("text/html");
	 
		PrintWriter out;
        out = response.getWriter();

     out.println(" el valor del nombre vale "+vname);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
