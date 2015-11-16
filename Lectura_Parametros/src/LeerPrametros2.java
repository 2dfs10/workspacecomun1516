

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//importar archivo de anotaciones

import javax.servlet.annotation.WebInitParam;
/**
 * Servlet implementation class LeerPrametros2
 */
@WebServlet(
        urlPatterns = "/LeerParametros2",
        initParams =
        {
            @WebInitParam(name = "saveDir", value = "D:/FileUpload"),
            @WebInitParam(name = "allowedTypes", value = "jpg,jpeg,gif,png")
        }
)
 

public class LeerPrametros2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LeerPrametros2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out;
        out = response.getWriter();

        response.setContentType("text/html");
        
        String vsaveDir = getInitParameter("saveDir");
        String vfileTypes = getInitParameter("allowedTypes");
        
        
        out.println("<html>");
        out.println("<head><title>Valor parametros inicialización</title></head>");
        out.println("<body>");
        out.println("<h1>Valor parametros inicialización</h1>");
        out.println("Directorio: " + vsaveDir + "<br/>");
        out.println("Tipo archivos permitidos: " + vfileTypes);
        out.println("<br><br><hr>");
        out.println("</body></html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
