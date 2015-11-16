/*
 * Ayuda.java
 *
 * autor Fco. Javier Ceballos
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Ayuda extends HttpServlet {
  // Se trata de una simulación
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
  throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>Ayuda</title></head>");
    out.println("<body><center>");
    String valor = request.getParameter("tema");
    if (valor.compareTo(new String("CarroCompra")) == 0)
      out.println("<h1>Ayuda carro de la compra</h1>");
    else
      out.println("<h1>Otra ayuda</h1>");
    out.println("<a href=\"http://localhost:8080/Cookies/CarroCompra\">" + 
                "continuar</a>");
    out.println("</center></body>");
    out.println("</html>");

    // Cerrar el flujo
    out.close();
  }
}