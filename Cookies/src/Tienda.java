/*
 * Tienda.java
 *
 * autor Fco. Javier Ceballos
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Tienda extends HttpServlet
{
  // Se trata de una simulación
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
  throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head><title>Tienda</title></head>");
    out.println("<body><center><h1>añadir/quitar artículos</h1>");
    out.println("<a href=\"/Cookies/CarroCompra\">" +
                "continuar</a>");
    out.println("<a href=\"/Cookies/pagar.html\">" +
                "<br><br>pagar</a>");
    out.println("</center></body>");
    out.println("</html>");

    // Cerrar el flujo
    out.close();
  }
  
  // Devuelve una descripción breve.
  public String getServletInfo()
  {
    return "Servlet Tienda";
  }
}
