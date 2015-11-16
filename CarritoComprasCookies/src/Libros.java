

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Libros
 */
@WebServlet("/Libros")
public class Libros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final Map libros = new HashMap();

	public void init() {
		libros.put("Java", "67.00");
		libros.put("C", "56.00");
		libros.put("C++", "63.00");
		libros.put("VB", "52.00");
		libros.put("Ruby", "48.50");
		libros.put("Phyton", "46.00");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie cookies[] = request.getCookies();
		Double sum = 0.0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<?xml version = \"1.0\"?>");
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD"
				+ "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>CARRITO DE COMPRAS</title>");
		out.println("</head>");
		out.println("<body>");

		if (cookies != null && cookies.length != 0) {
			out.println("<h1 align=center>Compra Total</h1>");
			out.println("<p>");
			out.println("<table width=298 border=1 cellpadding=6 align=center>");
			out.println("<tr>");
			out.println("<td width=208 align=center><strong><b>Titulo del Libro</b></strong></td>");
			out.println("<td width=74 align=center><strong><b>Precio</b></strong></td>");
			out.println("</tr>");
			for (int i = 0; i < cookies.length; i++) {
				out.println("<tr>");
				out.println("<td>" + cookies[i].getName()
						+ " Como programar.: </td>");
				out.println("<td>" + cookies[i].getValue() + "</td>");
				out.println("</tr>");
				sum = sum + Double.parseDouble(cookies[i].getValue());
			}
			out.println("</table>");
			out.println("<br>");
			out.println("<h2 align=center><b>Monto Total S/.:  " + sum
					+ "</b></h2>");
		} else {
			out.println("<H1>No hay recomendaciones </H1>");
			out.println("<p>Ud no selecciono ningun Libro</p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lenguaje = request.getParameter("listar");
		String precio = libros.get(lenguaje).toString();
		// Creamos el Cookie, este recibe dos parametros: Nombre y valor
		Cookie cookie = new Cookie(lenguaje, precio);
		// Añadir el cookie a la respuesta
		response.addCookie(cookie);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<?xml version = \"1.0\"?>");
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD"
				+ "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");
		out.println("<head><title>LIBRERIA ATLANTIDA</title></head>");
		out.println("<body>");
		out.println("<h1 >Bienvenidos Libreria Atlantida! Usted selecciono "
				+ lenguaje + "</h1>");
		out.println("<p><a href=\"index.html\">\"Clickee aqui para seguir comprando</a></p>");
		out.println("<p><a href=\"Libros\">\"Clickee aqui para ver el resumen de su compra</a>");
		out.println("</body>");
		out.println("</html>");

		out.close();

	}

}
