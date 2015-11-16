

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
@WebServlet("/InsertarTutoria")
public class InsertarTutoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
private Conecta conexion= new Conecta();
	
	String fila1;
	String fila2;
	String fila3;
	String fila4;
	String idProfe;
	ResultSet resultado = null;
       
   
    public InsertarTutoria() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Añadir una Tutoria</title>");
		out.println("<link href='estilo.css' rel='stylesheet' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='cabecera'><h1>Añadir una Tutoria</h1></div>");
		out.println("<form method='get' action='Insertar' name='formulario'>");
		out.println("<table id='mitabla'>"); //Tabla empieza aqui
		out.println("<tr><th>AGREGAR TUTORIA</th></tr><tbody>");
		
		
		
		try {
		
			fila1 =generaFilaParaSeleccionProfesor();
			out.println(fila1);
			
			fila2 =generaFilaParaSeleccionDia();
			out.println(fila2);
			
			fila3 =generaFilaParaSeleccionHora();
			out.println(fila3);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		out.println("<tr><td><a href='tutorias.html'>Atras</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<form method='get' action='Insertar' name='formulario'><input name='accion' value='insertarTutoria' type='hidden'><button>Añadir</button></form></td></tr>");
		out.println("</tbody>");
		out.println("</table>");  //Tabla termina aqui
		out.println("</form>");
		//out.println("<div id='pie'><p>Copyright © 2013 Felicia Perez. Todos los derechos reservados.</p></div>");
		out.println("</body>");
		out.println("</html>");
		
		
	
	}
	
	public String generaFilaParaSeleccionProfesor() throws SQLException {	//FILA1
		
		String fila1="";
		String consulta = "SELECT * FROM profesores";
		fila1 += "<tr><td>Profesor&nbsp;&nbsp;<select name='profesor'>";
		resultado = conexion.getSentencia().executeQuery(consulta);
		
		while(resultado.next()){
			String profesor = resultado.getString("profesor");
			fila1 += "<option>" + profesor + "</option>";
		}
		
		fila1 += "</select></td></tr>";
		return fila1;
		
	}
	
	public String generaFilaParaSeleccionDia() throws SQLException {	//FILA2
		
		String fila2="";
	
		fila2 += "<tr><td>Dia&nbsp;&nbsp;<select name='dia' align='rigth'>";
		fila2 += "<option>lunes</option><option>martes</option><option>miercoles</option><option>jueves</option><option>viernes</option>";
		fila2 += "</select></td></tr>";
	
		return fila2;
		
	}
	
	public String generaFilaParaSeleccionHora() throws SQLException {	//FILA3
		
		String fila3="";
		fila3 = "<tr><td>Hora:&nbsp;<input type='radio' name='hora' value='10' checked='checked'/>10:00<input type='radio' name='hora' value='12'/>12:00<input type='radio' name='hora' value='16'/>16:00<input type='radio' name='hora' value='18'/>18:00</td></tr>";
		
		return fila3;
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
