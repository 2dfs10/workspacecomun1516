

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertarCita")
public class InsertarCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
	
	String idProfesor;
	ResultSet resultadosProfesores = null; // objeto para guardar los resultados
	ResultSet resultadosDias = null; // objeto para guardar los resultados
	ResultSet resultadosHoras = null; // objeto para guardar los resultados
    
    public InsertarCita() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Concertar Tutoria</title>");
			out.println("<link href='estilo.css' rel='stylesheet' type='text/css'>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div id='cabecera'><h1>Tutorias</h1></div>");
			//out.println("<form method='get' action='http://localhost:8080/17.tutoriasRelaciones2/Insertar' name='formulario'>");
			out.println("<form method='get' action='Insertar' name='formulario'>");
			out.println("<table id='mitabla'>");
			out.println("<tr><th>SOLICITAR CITA</th></tr>");
			out.println("<tr><td>Alumno<input type='text' name='alumno' /></td></tr>");
			
			//Comienzo lista de profesores
			String consultaProfesores = "select * from profesores";
			out.println("<tr><td>Con el Profesor<select name='profesor'>");
			resultadosProfesores = conexion.getSentencia().executeQuery(consultaProfesores);
			
			while(resultadosProfesores.next()){
				String nombreProfe = resultadosProfesores.getString("profesor");
				idProfesor = resultadosProfesores.getString("id_profesor");
				out.println("<option>" + nombreProfe + "</option>");
			}
			
			out.println("</select>");
			//Termino lista de profesores
			
			//Comienzo Dias de Tutorias
			out.println("<tr><td>Dias<select name='dia'><option>Lunes</option><option>Martes</option><option>Miércoles</option><option>Jueves</option><option>Viernes</option></select>");
			//Termino Dias de Tutorias
			
			//Comienzo Horas de Tutorias
			out.println("<tr><td><input type='radio' name='hora' value='10'/>10:00<input type='radio' name='hora' value='12'/>12:00<input type='radio' name='hora' value='16'/>16:00<input type='radio' name='hora' value='18'/>18:00</td></tr>");
			//Termino Horas de Tutorias
			
			
	 
			out.println("<tr><td>Asunto<textarea name='asunto'></textarea></td></tr>"); 
			//out.println("<tr><td><input type='submit'></td></tr>");
			out.println("<tr><td><a href='citas.html'>Atras</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<form method='get' action='Insertar' name='formulario'><input name='accion' value='insertarCita1' type='hidden'><button>Añadir</button></form></td></tr>");
			out.println("</table>");
			out.println("</form>");
			//out.println("<div id='pie'><p>Copyright © 2013 Felicia Perez. Todos los derechos reservados.</p></div>");
			out.println("</body>");
			out.println("</html>"); 
			
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
			
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
