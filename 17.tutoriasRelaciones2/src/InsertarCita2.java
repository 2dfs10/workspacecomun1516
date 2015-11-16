

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertarCita2")
public class InsertarCita2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
	
	String fila1;
	String fila2;
	String fila3;
	String fila4;

	String idProfe;
	ResultSet resultadosTutoriasDisponibles = null; // objeto para guardar los resultados
	ResultSet resultadosTablaDisponibles = null;
	ResultSet resultadosDias = null; // objeto para guardar los resultados
	ResultSet resultadosHoras = null; // objeto para guardar los resultados
	ResultSet resultadosProfesores=null;
       
   
    public InsertarCita2() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Añadir una cita</title>");
		out.println("<link href='estilo.css' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='cabecera'><h1>Añadir una cita</h1></div>");
		out.println("<form method='get' action='Insertar' name='formulario'>");
		out.println("<table id='mitabla'>"); //Tabla empieza aqui
		out.println("<tr><th>TUTORIAS DISPONIBLES</th></tr>");
		
		
		
		try {
			fila1 =generaFilaInputAlumno();
			out.println(fila1);
			
			fila2 =generaFilaParaIdTutoriasDisponibles();
			out.println(fila2);
			
			fila3 =generaFilaParaTablaTutoriasDisponibles();
			out.println(fila3);
			
			fila4 =generaFilaTextAreaAsunto();
			out.println(fila4);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		

		
		
 
		 
		//out.println("<tr><td><a href='citas.html'>Atras</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<input type='submit' value='Añadir'></td></tr>"); //Fila para el boton submit
		out.println("<tr><td><a href='citas.html'>Atras</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<form method='get' action='Insertar' name='formulario'><input name='accion' value='insertarCita' type='hidden'><button>Añadir</button></form></td></tr>");
		
		
		
		
		out.println("</table>");  //Tabla termina aqui
		out.println("</form>");
		//out.println("<div id='pie'><p>Copyright © 2013 Felicia Perez. Todos los derechos reservados.</p></div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
	public String generaFilaInputAlumno() {		//FILA1
		String fila1="";
		fila1 ="<tr><td>Alumno<input type='text' name='alumno' /></td></tr>";
		return fila1;
	}
	
	public String generaFilaParaIdTutoriasDisponibles() throws SQLException {	//FILA2
		
		String fila2="";
		String consultaTutoriasDisponibles = "SELECT * FROM tutorias where id_tutoria NOT IN (SELECT id_tutoria FROM citas)";
		fila2 += "<tr><td>Id Tutoria<select name='tutoriasId'>";
		resultadosTutoriasDisponibles = conexion.getSentencia().executeQuery(consultaTutoriasDisponibles);
		
		while(resultadosTutoriasDisponibles.next()){
			String idtutoria = resultadosTutoriasDisponibles.getString("id_tutoria");
			fila2 += "<option>" + idtutoria + "</option>";
		}
		
		fila2 += "</select></td></tr>";
		return fila2;
		
	}
	

	
	public String generaFilaParaTablaTutoriasDisponibles() throws SQLException {		//FILA3
		String fila3 = "";
		
		//Comienzo tabla de Tutorias
		String consultaTablaDisponibles = "SELECT t.id_tutoria,t.dia,t.hora,p.profesor FROM tutorias t JOIN profesores p on (t.id_profesor = p.id_profesor) where  t.id_tutoria NOT IN (SELECT id_tutoria FROM citas) GROUP BY id_tutoria";
		fila3 += "";
		fila3 += "<tr><td><table><tr><th>Id tutoria</th><th>Dia/Hora</th><th>Con el Profesor</th></tr>";
		resultadosTablaDisponibles = conexion.getSentencia().executeQuery(consultaTablaDisponibles);
		
		while(resultadosTablaDisponibles.next()){
			
			String idtutoria = resultadosTablaDisponibles.getString("id_tutoria");
			String dia = resultadosTablaDisponibles.getString("dia");
			String hora = resultadosTablaDisponibles.getString("hora");
			String profesor = resultadosTablaDisponibles.getString("profesor"); 
		
			fila3 += "<tr><td>" + idtutoria + "</td><td>" + dia + " " + hora + "</td><td>"+ profesor + "</td></tr>";
		}
		
		fila3 += "</table></td></tr>";
		return fila3;
	
		//Termino Tabla de Tutorias
		
	}
	
	public String generaFilaTextAreaAsunto() {		//FILA4
		String fila4 = "";
		fila4 = "<tr><td>Asunto &nbsp; &nbsp;<textarea name='asunto'></textarea></td></tr>";
		return fila4;
	}
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

