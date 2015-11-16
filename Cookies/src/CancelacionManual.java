/*
 * CancelacionManual.java
 *
 */

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CancelacionManual extends HttpServlet
{
  public void doGet(HttpServletRequest request, 
                    HttpServletResponse response)
  throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Cancelación manual</title></head>");
    out.println("<body><center>");

    // Obtener la sesión actual; crear una si fuera necesario.
    HttpSession sesión = request.getSession(true);
    
    // Cancelar la sesión si transcurrieron más de 3 horas desde
    // que fue creada o ha permanecido inactiva más de 1 minutos.
    if (!sesión.isNew()) // si la sesión no es nueva
    {  
      out.println("<p><h3>Sesión en curso</h3></p>");
      Date transcurrido = new Date(System.currentTimeMillis() -
                                   3*60*60*1000);
      Date inactividad = new Date(System.currentTimeMillis() -
                                   1*60*1000);
      Date creada = new Date(sesión.getCreationTime());
      Date accedida = new Date(sesión.getLastAccessedTime());

      if (creada.before(transcurrido) || accedida.before(inactividad))
      {
        sesión.invalidate();
        out.println("<p><h3>Sesión cancelada</h3></p>");
        sesión = request.getSession(true);  // una nueva sesión
        out.println("<p><h3>Se inicia una sesión nueva</h3></p>");
      }
    }
    else
      out.println("<p><h3>Sesión nueva</h3></p>");
    out.println("</center></body></html>");

    // Continuación del proceso...
  }
}
