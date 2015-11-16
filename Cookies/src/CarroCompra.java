/*
 * CarroCompra.java
 *
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class CarroCompra extends HttpServlet
{
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
  throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    
    // Obtener el identificador de sesión actual buscando entre
    // las cookies recibidas.
    String idSesion = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
      for (int i = 0; i < cookies.length; i++)
      {
        if (cookies[i].getName().equals("idSesion"))
        {
          idSesion = cookies[i].getValue();
          break;
        }
      }
    }
    
    // Si el identificador de sesión no fue enviado, generar uno.
    // Después, asegurarse de enviárselo al cliente con la
    // respuesta (response).
    if (idSesion == null)
    {
      idSesion = generarIdSesion();
      Cookie c = new Cookie("idSesion", idSesion);
      response.addCookie(c);
    }
    
    out.println("<head>");
    out.println("<title>Carro de la compra</title>");
    out.println("</head>");
    out.println("<body>");
    // Ofrecer una página de ayuda
    out.println("Para obtener ayuda, haga clic " + 
                "<a href=\"/Cookies/Ayuda" +
                "?tema=CarroCompra\">aquí</a><p>");
    
    // Los artículos son asociados con el ID de sesión
    String[] items = articulosComprados(idSesion);
    
    // Mostrar los artículos actuales.
    out.println("Artículos que hay en tu carro:<br>");
    if (items == null)
    {
      out.println("<b>Ninguno</b>");
    }
    else
    {
      out.println("<ul>");
      for (int i = 0; i < items.length; i++)
      {
        out.println("<li>" + items[i]);
      }
      out.println("</ul>");
    }
    
    // Preguntar si se quiere añadir más elementos o finalizar.
    out.println("<form action=\"http://localhost:8080/Cookies/Tienda\"" +
                " method=post>");
    out.println("Desea<br>");
    out.println("<input type=submit value=\"añadir artículos\">");
    out.println("<input type=submit value=\"pagar\">");
    out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
  }
  
  private static String generarIdSesion()
  {
    // Garantizar un id único
    String uid = new java.rmi.server.UID().toString();
    try
    {
      // Codificar cualquier carácter especial
      return java.net.URLEncoder.encode(uid, "UTF-8");
    }
    catch(UnsupportedEncodingException e) {}
    return null;
  }
  
  private static String[] articulosComprados(String idSesion)
  {
    // No implementado.
    // Simulación:
    // if (idSesion == xxx)...
    Random rnd = new Random();
    int i, n = rnd.nextInt(8)+1;
    String[] art = new String[n];
    for (i = 0; i < n; ++i)
      art[i] = "art0"+i;
    return art;
  }
}
