import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/")
@WebServlet("/Consultas")
public class Consultas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Conecta conexion= new Conecta();
	ResultSet resultado = null; // 
	String mensaje = "";
	String cabeceraTabla;
	String botonAtras;

       
   
    public Consultas() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String accion = request.getParameter("accion");

		
		
		try {

		switch(accion) {
		
		case "consultacitasprofesor":
									String consultacitasprofesor = request.getParameter("profesor");
									mensaje = consultacitasprofesor(consultacitasprofesor,response);
									break;
		case "consultacitasalumno":
									String consultacitasalumno = request.getParameter("alumno");
									mensaje= consultacitasalumno(consultacitasalumno,response);
									break;
		case "consultacitatodas":
									mensaje = consultacitatodas(response);
									break;								
		case "consultatutoriasprofesor":
									String consultatutoriasprofesor = request.getParameter("profesor");                     
									mensaje = consultatutoriasprofesor(consultatutoriasprofesor,response);
									break;
		case "consultatutoriaid":																	
									String consultatutoriaid = request.getParameter("id");						
									//mensaje = "<tr><td>No existen tutorias con este ID!!! " + consultatutoriaid + "</td></tr>";
									mensaje = consultatutoriaid(consultatutoriaid,response);
									break;
		case "consultatutoriastodas":
									cabeceraTabla = "";								
									mensaje = consultatutoriastodas(response);
									break;								
		case "consultasoloprofesor":
									String consultasoloprofesor = request.getParameter("profesor");
									mensaje = consultasoloprofesor(consultasoloprofesor,response);
									break;
		case "consultatodosprofesor":
									mensaje = consultatodosprofesor(response);
									break;						
	
		} 
		
		
		//Construye pagina
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Tutorias</title>");
		out.println("<link rel='stylesheet' href='estilo.css' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='cabecera'><h1>Tutorias</h1>");
	  	out.println("</div>");
	  	out.println("<table border='1' id='mitabla'>");
	  	out.println(cabeceraTabla);
	  	out.println("<tbody>");
	  	out.println(mensaje);
	  	out.println("<tr id='botonAtras'>" + botonAtras + "</tr>");
		out.println("</tbody>");
	  	out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		//String consultaCitas = "SELECT * FROM citas WHERE id_tutoria IN (SELECT id_tutoria FROM tutorias WHERE id_profesor='"+id_prof+"');";	
		//Fin construye pagina
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public String consultacitasprofesor(String profesor,HttpServletResponse response) throws SQLException {   
		String consulta = "SELECT c.alumno,c.asunto,t.dia,t.hora FROM citas c JOIN tutorias t on (t.id_tutoria = c.id_tutoria) JOIN profesores p on (p.id_profesor = t.id_profesor)WHERE p.profesor = '"+profesor+"'";
		String mensaje = "";	
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("c.alumno") + "</td><td>" + resultado.getString("c.asunto") + "</td><td>" + resultado.getString("t.dia") + "</td><td>" + resultado.getString("t.hora") + "</td></tr>";
			} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Lista de Citas de Profesor " +"<br/>" + profesor + "</caption><tr><th>Alumno</th><th>Asunto</th><th>Dia</th><th>Hora</th></tr>";
		botonAtras = "<td><form action='citasconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>Este profesor no tiene citas!!!</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=citasconsultaprofesor.html");
	
		}
		return mensaje;
	}
	
	public String consultacitasalumno(String alumno,HttpServletResponse response) throws SQLException {   //Por aqui -------------------------------
		String consulta = "SELECT p.profesor,c.asunto,t.dia,t.hora FROM citas c JOIN tutorias t on (t.id_tutoria = c.id_tutoria) JOIN profesores p on (p.id_profesor = t.id_profesor)WHERE c.alumno = '"+alumno+"'";
		String mensaje = "";	
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("p.profesor") + "</td><td>" + resultado.getString("c.asunto") + "</td><td>" + resultado.getString("t.dia") + "</td><td>" + resultado.getString("t.hora") + "</td></tr>";
			} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Lista de Citas de Alumno " +"<br/>" + alumno + "</caption><tr><th>Profesor</th><th>Asunto</th><th>Dia</th><th>Hora</th></tr>";
		botonAtras = "<td><form action='citasconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>Este alumno no tiene citas!!!</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=citasconsultaalumno.html");
	
		}
		return mensaje;
	}
	
	public String consultacitatodas(HttpServletResponse response) throws SQLException {
	
		String mensaje = "";
		String consulta = "SELECT p.profesor,c.alumno,c.asunto,t.dia,t.hora FROM citas c JOIN tutorias t on (t.id_tutoria = c.id_tutoria) JOIN profesores p on (p.id_profesor = t.id_profesor)";		
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("p.profesor") + "</td><td>" + resultado.getString("c.alumno") + "</td><td>" + resultado.getString("c.asunto") + "</td><td>" + resultado.getString("t.dia") + "</td><td>" + resultado.getString("t.hora") + "</td></tr>";
		} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Lista de Citas " + "</caption><tr><th>Profesor</th><th>Alumno</th><th>Asunto</th><th>Dia</th><th>Hora</th></tr>";
		botonAtras = "<td><form action='citasconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>No existen citas</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=citasconsulta.html");
	
		}
		
		return mensaje;
	}
	
	public String consultatutoriasprofesor(String profesor,HttpServletResponse response) throws SQLException {   
		String consulta = "SELECT dia,hora FROM tutorias WHERE id_profesor = (SELECT id_profesor FROM profesores WHERE profesor = '"+profesor+"')";
		String mensaje = "";	
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("dia") + "</td><td>" + resultado.getString("hora") + "</td></tr>";
			} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Lista de Tutorias de Profesor " +"<br/>" + profesor + "</caption><tr><th>Dia</th><th>Hora</th></tr>";
		botonAtras = "<td><form action='tutoriasconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>Este profesor no tiene Tutorias!!!</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=tutoriasconsultaprofesor.html");
	
		}
		return mensaje;
	}
	
	
	public String consultatutoriaid(String id_tut,HttpServletResponse response) throws SQLException {  
		
		String consulta = "SELECT p.profesor,t.dia,t.hora FROM tutorias t JOIN profesores p on (p.id_profesor = t.id_profesor) WHERE t.id_tutoria = '"+id_tut+"'";
		String mensaje = "";	
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("p.profesor") + "</td><td>" + resultado.getString("t.dia") + "</td><td>" + resultado.getString("t.hora") + "</td></tr>";
			} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Tutoria ID " + id_tut + "</caption><tr><th>Profesor<th>Dia</th><th>Hora</th></tr>";
		botonAtras = "<td><form action='tutoriasconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>No existen tutorias con este ID!!!</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=tutoriasconsultaid.html");
	
		}
		return mensaje;
	}
	
	public String consultatutoriastodas(HttpServletResponse response) throws SQLException {
		
		String mensaje = "";
		String consulta = "SELECT t.id_tutoria,p.profesor,t.dia,t.hora FROM tutorias t JOIN profesores p on (p.id_profesor = t.id_profesor) GROUP BY t.id_tutoria";		
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("t.id_tutoria") + "</td><td>" + resultado.getString("p.profesor") + "</td><td>" + resultado.getString("t.dia") + "</td><td>" + resultado.getString("t.hora") + "</td></tr>";
		} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Lista de Tutorias " + "</caption><tr><th>Id Tutoria</th><th>Profesor</th><th>Dia</th><th>Hora</th></tr>";
		botonAtras = "<td><form action='tutoriasconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>No existen Tutorias</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=tutoriasconsulta.html");
	
		}
		
		return mensaje;
	}
	
	public String consultasoloprofesor(String profesor,HttpServletResponse response) throws SQLException {
		
		String mensaje = "";
		String consulta = "SELECT id_profesor,profesor FROM profesores WHERE profesor = '"+profesor+"'";		
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("id_profesor") + "</td><td>" + resultado.getString("profesor") + "</td></tr>";
		} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Profesor " + profesor + "</caption><tr><th>Id Profesor</th><th>Nombre</th></tr>";
		botonAtras = "<td><form action='consultarprofesor.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>No existe este profesor</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=consultarprofesor.html");
	
		}
		
		return mensaje;
	}
	
	public String consultatodosprofesor(HttpServletResponse response) throws SQLException {
		
		String mensaje = "";
		String consulta = "SELECT id_profesor,profesor FROM profesores GROUP BY id_profesor";		
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
		while(resultado.next()) {	
			mensaje += "<tr><td>" + resultado.getString("id_profesor") + "</td><td>" + resultado.getString("profesor") + "</td></tr>";
		} 
		cabeceraTabla = "<caption style= 'font-size:20px;color:#018A97;'>Lista de profesores " + "</caption><tr><th>Id Profesor</th><th>Profesor</th></tr>";
		botonAtras = "<td><form action='profesoresconsulta.html'><button>Atras</button></form></td>";
		}
		else
		{
		mensaje = "<tr><td>No existen profesores</td></tr>";	
		cabeceraTabla="";
		response.setHeader("Refresh", "2;URL=profesoresconsulta.html");
	
		}
		
		return mensaje;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
