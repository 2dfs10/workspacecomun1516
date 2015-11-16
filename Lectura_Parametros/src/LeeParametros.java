

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
 * Servlet implementation class LeeParametros
 */

public class LeeParametros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String vnivelLog;
     private int vnumeroPeticiones;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeeParametros() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void destroy() {
		// TODO Auto-generated method stub
    	
    	System.gc();
    	
	}
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try{
            vnivelLog = config.getInitParameter("NivelLog");        
            vnumeroPeticiones = Integer.parseInt(config.getInitParameter("NumeroPeticiones"));
    } catch(NullPointerException npe){
            npe.printStackTrace();
    }
		
		
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out;
        out = response.getWriter();

        response.setContentType("text/html");

        out.println("<html>");
        out.println("<head><title>Valor parametros inicialización</title></head>");
        out.println("<body>");
        out.println("<h1>Valor parametros inicialización</h1>");
        out.println("Nivel Log: " + vnivelLog + "<br/>");
        out.println("Numero Peticiones: " + vnumeroPeticiones);
        out.println("<br><br><hr>");
        out.println("</body></html>");
}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
