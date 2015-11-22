
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/SvMostrarConv")
public class SvMostrarConv extends HttpServlet
{
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
  throws IOException, ServletException
  {
    String[] conversación = Conversacion.obtenerConversacion();
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    // Refrescar la conversación cada 6 segundos
    out.println("<html><head>" +
      "<meta http-equiv='refresh' " +
            "content='3;" +
            "url=SvMostrarConv'>" +
    "</head><body><font face='Arial'>");
    // Enviar los mensajes almacenados en conversación. El último
    // es el más reciente.
    for (int i = 0; i < conversación.length; ++i)
    {
      out.println(conversación[i] + "<br>");
    }
    out.println("</body></html>");
  }
}
