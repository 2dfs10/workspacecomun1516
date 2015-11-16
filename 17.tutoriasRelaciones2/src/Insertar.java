

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/")
@WebServlet("/Insertar")
public class Insertar extends HttpServlet {
private static final long serialVersionUID = 1L;
private Conecta conexion= new Conecta();
ResultSet resultado = null; 
String mensaje;
String cabeceraTabla;
String cabecera;
//String id_prof;
String id_tut;
String botonAtras;
  
    public Insertar() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String accion = request.getParameter("accion");
	
		
		try {
			
		
		switch(accion) {
		
		case "insertarCita1":
			
								String alumno1 = request.getParameter("alumno");
								String profesor1 = request.getParameter("profesor");
								String asunto1 = request.getParameter("asunto");
								String dia1 = request.getParameter("dia");
								String hora1 = request.getParameter("hora");
								mensaje = "<tr><td>" + alumno1 + "</td></tr>";
								String id_pr = idProfesor(profesor1);
								//mensaje ="<tr><td>Esta tutoria no existe!!!</td></tr>";
								if(existeTutoria(id_pr, dia1, hora1))
								{
									String id_tut = idTutoria(id_pr, dia1, hora1);
												if(tutoriaOcupada(id_tut)) {
													mensaje ="<tr><td>Esta tutoria ya esta ocupada Elije una disponible!!! </td></tr>";
													response.setHeader("Refresh", "2;URL=InsertarCita2");
												}
												if(!tutoriaOcupada(id_tut)) {
													mensaje ="<tr><td>Tutoria agregada con exito!!! </td></tr>";
													mensaje = insertarCita(id_tut,alumno1,asunto1);
													cabeceraTabla = "";
													response.setHeader("Refresh", "2;URL=InsertarCita");
												}
									
								}
								
								else if(!existeTutoria(id_pr, dia1, hora1)) {
									
								mensaje ="<tr><td>Esta tutoria NO existe Elije una disponible!!! </td></tr>";
								response.setHeader("Refresh", "2;URL=InsertarCita2");
								cabeceraTabla = "";
								}
							
								break;						
		
		case "insertarCita": 
								String alumno = request.getParameter("alumno");
								String id_tut = request.getParameter("tutoriasId");
								String asunto = request.getParameter("asunto");
			
								mensaje = insertarCita(id_tut,alumno,asunto);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=InsertarCita");
								break;
								
		case "insertarTutoria": 
								// ALTER TABLE `tutorias` AUTO_INCREMENT=21
								String profe = request.getParameter("profesor");
								String dia = request.getParameter("dia");
								String hora = request.getParameter("hora");
								String id_pro = idProfesor(profe);
								mensaje = "<tr><td>Esta tutoria ya existe!!!</td></tr>";
								if(!existeTutoria(id_pro,dia,hora)) mensaje = insertarTutoria(id_pro,dia,hora);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=InsertarTutoria");
								break;						
		
		case "insertarprofesor": 
								//ALTER TABLE `profesores` AUTO_INCREMENT=319
								String nombreProfesor = request.getParameter("profesor");
								mensaje = insertarprofesor(nombreProfesor);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=profesores.html");
								break;
		case "borraprofesortodos": 
								
								mensaje = borraprofesortodos();
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=profesores.html");
								break;
		case "borraprofesor": 	
								String nombreProfe = request.getParameter("profesor");
								mensaje = borraprofesor(nombreProfe);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=profesores.html");
								break;
		case "borrarcitatodas":
													
								mensaje = borrarcitatodas();
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=citas.html");
								break;	
		case "borrarcitaalumno":
								String borrarcitaalumno = request.getParameter("alumno");							
								mensaje = borrarcitaalumno(borrarcitaalumno);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=citasborrar.html");
								break;	
		case "borrarcitaprofesor":
								String borrarcitaprofesor = request.getParameter("profesor");								
								mensaje = borrarcitaprofesor(borrarcitaprofesor);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=citasborrar.html");
								break;						
		case "borrartutoriaid":				
								String borrartutoriaid = request.getParameter("id");						
								mensaje = borrartutoriaid(borrartutoriaid);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=tutoriasborrar.html");
								break;	
		case "borrartutoriaprofesor":
								String borrartutoriaprofesor = request.getParameter("profesor");
								mensaje = borrartutoriaprofesor(borrartutoriaprofesor);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=tutoriasborrar.html");
								break;							
		case "borrartutoriatodas":
								
								mensaje = borrartutoriatodas();
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=tutorias.html");
								break;	
		case "modificartutoria":
								String modificarid = request.getParameter("id");
								String modificardia = request.getParameter("dia");
								String modificarhora = request.getParameter("hora");
								mensaje = modificartutoria(modificarid,modificardia,modificarhora);
								cabeceraTabla = "";
								response.setHeader("Refresh", "2;URL=tutoriasmodificar.html");
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
		//Fin construye pagina
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String insertarCita(String id_tutoria,String alumno,String asunto) throws SQLException {
		if(alumno=="") alumno = null;
		if(asunto=="") asunto = null;
		String consulta = "INSERT INTO citas VALUES('"+id_tutoria+"','"+alumno+"','"+asunto+"')";
		if(alumno != null && asunto != null) {
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Tutoria Insertada.";
			mensaje = "<tr><td>Cita Añadida con exito!!!</td></tr>";	
	
			} else {
				cabecera = "Valores Incorrectos!!";
				mensaje = "<tr><td>Valores Incorrectos!!!</td></tr>";
			}
		return mensaje;
	}
	
	public String insertarCita1(String profesor,String alumno,String asunto) throws SQLException {
		if(alumno=="") alumno = null;
		if(asunto=="") asunto = null;
		String consulta = "";
		if(alumno != null && asunto != null) {
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Tutoria Insertada.";
			mensaje = "<tr><td>Cita Añadida con exito!!!</td></tr>";	
	
			} else {
				cabecera = "Valores Incorrectos!!";
				mensaje = "<tr><td>Valores Incorrectos!!!</td></tr>";
			}
		return mensaje;
	}
	
	public String insertarTutoria(String id_profesor,String dia,String hora) throws SQLException {
		
		
		String consulta = "INSERT INTO tutorias VALUES(null,'"+id_profesor+"','"+dia+"','"+hora+"')";
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Tutoria Insertada.";
			mensaje = "<tr><td>Tutoria Añadida con exito!!!</td></tr>";	
	
		return mensaje;
	}
	
	public String insertarprofesor(String profesor) throws SQLException {
		
		String consulta = "INSERT INTO profesores VALUES(null,'" +profesor+"')";
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Profesor Añadido.";
			mensaje = "<tr><td>Profesor Añadido con exito!!!</td></tr>";	
	
		return mensaje;
	}
	
	public String borraprofesortodos() throws SQLException {
		
		String consulta = "DELETE FROM profesores";
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Todos los profesores borrados.";
			mensaje = "<tr><td>Profesores Borrados con exito!!!</td></tr>";	
	
		return mensaje;
	}
	
	public String borraprofesor(String profesor) throws SQLException {
		
		String consulta = "DELETE FROM profesores WHERE profesor=('"+profesor+"')";
		
		if(conexion.getSentencia().executeUpdate(consulta) != 0) {
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Profesor Borrado.";
			mensaje = "<tr><td>Profesor Borrado con exito!!!</td></tr>";	
		}
		else {
			
			cabecera = "Profesor no existe.";
			mensaje = "<tr><td>Profesor no existe!!!</td></tr>";	
			
		}
	
		return mensaje;
	}
	
	public String borrarcitatodas() throws SQLException {
		
		String consulta = "DELETE FROM citas";
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Todas las citas borradas.";
			mensaje = "<tr><td>Citas Borradas con exito!!!</td></tr>";	
	
		return mensaje;
	}
	
	public String borrarcitaalumno(String alumno) throws SQLException {
		
		String consulta = "DELETE FROM citas WHERE alumno=('"+alumno+"')";
		
		if(conexion.getSentencia().executeUpdate(consulta) != 0) {
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Citas de " + alumno + " borradas.";
			mensaje = "<tr><td>Citas de " + alumno + " borradas con exito!!!</td></tr>";	
		}
		else {
			
			cabecera = "No hay citas con este Alumno.";
			mensaje = "<tr><td>No hay citas con este Alumno.!!</td></tr>";
		}
	
		return mensaje;
	}
	
	public String borrarcitaprofesor(String profesor) throws SQLException {
	
		String consulta = "DELETE FROM citas WHERE id_tutoria IN (select id_tutoria FROM tutorias where id_profesor =(select id_profesor FROM profesores where profesor='"+profesor+"'))";
		
			if(conexion.getSentencia().executeUpdate(consulta) != 0) {
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Citas de " + profesor + " borradas.";
			mensaje = "<tr><td>Citas de " + profesor + " borradas con exito!!!</td></tr>";	
			}
			else {
				cabecera = "No hay citas con este Profesor.";
				mensaje = "<tr><td>No hay citas con este Profesor!!</td></tr>";
				
			}
		
	
	
		return mensaje;
	}
	
	public String borrartutoriaprofesor(String profesor) throws SQLException {
		
		String consulta = "DELETE FROM tutorias WHERE id_profesor IN (SELECT id_profesor FROM profesores WHERE profesor = '"+profesor+"')";
		
		if(conexion.getSentencia().executeUpdate(consulta) != 0) {
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Tutorias de " + profesor + " borradas.";
			mensaje = "<tr><td>Tutorias de " + profesor + " borradas con exito!!!</td></tr>";	
		}
		else {
			
			cabecera = "No hay Tutorias con este Profesor.";
			mensaje = "<tr><td>No hay Tutorias con este Profesor.!!</td></tr>";
		}
	
		return mensaje;
	}
	
	public String borrartutoriaid(String id) throws SQLException {
		
		String consulta = "DELETE FROM tutorias WHERE id_tutoria = '"+id+"'";
		
		if(conexion.getSentencia().executeUpdate(consulta) != 0) {
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Tutoria ID " + id + " eliminada.";
			mensaje = "<tr><td>Tutoria ID " + id + " eliminada con exito!!!</td></tr>";	
		}
		else {
			
			cabecera = "No existen tutorias con este ID!!!";
			mensaje = "<tr><td>No existen tutorias con este ID!!!</td></tr>";
		}
	
		return mensaje;
	}
	
	public String borrartutoriatodas() throws SQLException {
		
		String consulta = "DELETE FROM tutorias";
		
			conexion.getSentencia().executeUpdate(consulta);
			cabecera = "Todas las tutorias borradas.";
			mensaje = "<tr><td>Tutorias Borradas con exito!!!</td></tr>";	
	
		return mensaje;
	}
	
	public String modificartutoria(String id,String dia,String hora) throws SQLException {
		
		String consulta = "UPDATE tutorias SET dia='"+dia+"',hora='"+hora+"' WHERE id_tutoria='"+id+"'";
		
		
			if(conexion.getSentencia().executeUpdate(consulta) != 0) {
			conexion.getSentencia().executeUpdate(consulta);
			mensaje = "<tr><td>Tutoría modificada con éxito!!!</td></tr>";	
			
			}
			else {
				mensaje = "<tr><td>Tutoría no existe!!!</td></tr>";	
			}
	
		return mensaje;
	}
	
	public String idProfesor(String profesor) throws SQLException {
		
		String id_prof = "";
		String consulta = "SELECT * FROM profesores WHERE profesor='"+profesor+"'";
		resultado = conexion.getSentencia().executeQuery(consulta);
		while(resultado.next()) id_prof = resultado.getString("id_profesor");	
		return id_prof;
		
	}
	
	public boolean existeTutoria(String id_profesor,String dia,String hora) throws SQLException {  
		boolean esta = false;
		String consulta = "SELECT id_profesor,dia,hora FROM tutorias WHERE id_profesor='"+id_profesor+"' AND dia='"+dia+"' AND hora='"+hora+"' ";
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
			
			while(resultado.next()) {
				esta = true;
			}
		}
		return esta;
	
	}
	
	public String idTutoria(String id_profesor,String dia,String hora) throws SQLException {  
		String id_tut = "";
		String consulta = "SELECT id_tutoria FROM tutorias WHERE id_profesor='"+id_profesor+"' AND dia='"+dia+"' AND hora='"+hora+"' ";
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
			
			while(resultado.next()) {
				id_tut = resultado.getString("id_tutoria");
			}
		}
		return id_tut;
		
	
	}
	
	public boolean tutoriaOcupada(String id_tut) throws SQLException {  
		boolean ocupada = false;
		String consulta = "SELECT * FROM citas WHERE id_tutoria='"+id_tut+"'";
		resultado = conexion.getSentencia().executeQuery(consulta);
		if (resultado.isBeforeFirst()) {
			
			while(resultado.next()) {
				ocupada=true;
			}
		}
		return ocupada;
		
	
	}
	

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
