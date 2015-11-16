package jdbcestructurado;

// Error de Seguridad, cuando vienen de datos formulario y los campos tienen comillas  O'Donell , 
// al montar la sentencia SQL , Error.
// usar Prepares Statement
// Enlace explicado
//http://www.chuidiang.com/java/mysql/PreparedStatement-java-mysql.php 
	


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultaPrepared
 */
@WebServlet("/ConsultaPrepared")
public class InsertaPrepared extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String db = "jdbc:mysql://127.0.0.1:3306/tutorias";

	// para Oracle
	// private final String db = ""jdbc:oracle:thin:@localhost:1521:tutorias";
	private Conecta conexion= new Conecta();
	
 
	
   
    public InsertaPrepared() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			PreparedStatement ps= null;
			
			String inserta = "INSERT INTO tutorias_t2 VALUES(null,?,?,?,?,?)";
			try {
			
				
				
				ps = conexion.getSentencia().getConnection().prepareStatement(inserta);
	
				ps.setString(1, "pimero111");
				ps.setString(2, "dos2 interrogante");
				ps.setString(3, "tres3");
				ps.setString(4, "cuatro4 ");
				ps.setString(5, "cinco5 ");
		 
				ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		
			
			
			
		
		// Creamos una sentencia a partir de la conexión

		//sentencia = conexion.createStatement();
		 // sentencia.executeUpdate(consulta);
		
		//Ejecutamos la orden SQL
		
	/*	try {
			
			
					
					prepareStatement("INSERT INTO clientes VALUES (?,?,?,?) ");
			
			conexion.getSentencia().executeUpdate(insertodato);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
