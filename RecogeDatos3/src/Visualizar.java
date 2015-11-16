
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Visualizar
 */
@WebServlet("/Visualizar")
public class Visualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Visualizar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Recogida de Datos en un Servlet</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<big style='font-weight: bold;'>");

		out.println("<big><big> RECOGIDA DE DATOS TUTORÍA</big></big></big>");

		/*
		 * <big style="font-weight: bold;"><big><big> RECOGIDA DE DATOS
		 * TUTORÍA</big></big></big>
		 */
	
	
		
		out.print("<form method='get' action='Recogetutoria' name='formulario1'>");
		
		
		out.print("<input  name='oculto' value='1' type='hidden'>");
		
		out.print("<br> Nombre del Alumno : &nbsp;");

		out.print("<input maxlength='40' size='20' name='alumno'>");

		out.print("<br> <br> <br> Nombre del profesor: &nbsp;");

		out.print("<select name='profesor'>");
		out.print("<option>miguel</option>");
		out.print("<option selected='selected'>rosa</option>");
		out.print("<option>ignacio</option>");

		/*
		 * </select> <br> <br> <br> Hora Tutoría: &nbsp; &nbsp; &nbsp; &nbsp;
		 * &nbsp; &nbsp;&nbsp;<input name="hora" value="10" type="radio">10
		 * &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input
		 * checked="checked" name="hora" value="12" type="radio"> &nbsp;12
		 * &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input
		 * name="hora" value="14" type="radio">14<br> <br> &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <br> Asignatura: &nbsp; &nbsp;
		 * &nbsp; &nbsp; <input name="asignatura" value="dwes" type="checkbox">
		 * DWES &nbsp; &nbsp; &nbsp;&nbsp;<input checked="checked"
		 * name="asignatura" value="dwec" type="checkbox"> DWEC &nbsp; &nbsp;
		 * &nbsp;<input name="asignatura" value="da" type="checkbox">&nbsp;
		 * &nbsp; DA &nbsp; &nbsp; &nbsp; <input name="asignatura" value="di"
		 * type="checkbox"> DI<br> <br> <br> Observaciones<br> <br>
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <textarea cols="40" rows="6"
		 * name="observaciones"></textarea> <br> <br> <br> &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
		 * &nbsp;&nbsp;&nbsp;
		 */
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");

		out.print("&nbsp;&nbsp;&nbsp;<input name='enviar' value='Enviar Datos'	type='submit'>");
		out.println("<br>");
		out.println("<br>");
		out.print("<br>");
		out.print("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;");
		/*
		 * <input name="borrar" value="Reset Datos" type="reset"><br> <br> <br>
		 * <br> <br> <br>
		 */
		out.print("</form>");

		
		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
